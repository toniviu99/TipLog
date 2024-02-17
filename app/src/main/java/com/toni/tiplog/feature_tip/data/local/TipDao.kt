package com.toni.tiplog.feature_tip.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.toni.tiplog.feature_tip.data.local.entity.TipEntity
import com.toni.tiplog.feature_tip.domain.model.MonthAmount
import com.toni.tiplog.feature_tip.domain.model.Tip
import kotlinx.coroutines.flow.Flow

@Dao
interface TipDao {
    @Query("SELECT * FROM TipEntity")
    fun getAllTips(): Flow<List<TipEntity>>

//    @Query("SELECT DISTINCT SUBSTR(date, 4) AS month FROM TipEntity ORDER BY date ASC")
//    fun getAllMonths(): Flow<List<String>>

    @Query("SELECT DISTINCT SUBSTR(date, 4) AS month, SUM(amount) AS totalAmount FROM TipEntity GROUP BY month ORDER BY month DESC")
    fun getMonthAmount(): Flow<List<MonthAmount>>

    @Query("SELECT * FROM TipEntity WHERE date LIKE '%' || :month ORDER BY date DESC")
    fun getTipsByMonth(month: String): Flow<List<TipEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTip(tip: TipEntity)

    @Delete
    suspend fun deleteTip(tip: TipEntity)
}