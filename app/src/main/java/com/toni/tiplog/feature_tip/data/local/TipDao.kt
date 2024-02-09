package com.toni.tiplog.feature_tip.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.toni.tiplog.feature_tip.data.local.entity.TipEntity
import com.toni.tiplog.feature_tip.domain.model.Tip
import kotlinx.coroutines.flow.Flow

@Dao
interface TipDao {
    @Query("SELECT * FROM Tip")
    fun getAllTips(): Flow<List<Tip>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTip(tip: Tip)

    @Delete
    suspend fun deleteTip(tip: Tip)
}