package com.toni.tiplog.feature_tip.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.toni.tiplog.feature_tip.domain.model.Tip
import kotlinx.coroutines.flow.Flow

@Dao
interface TipDao {
    @Query("SELECT * FROM tip")
    fun getAllTips(): Flow<List<Tip>>

    @Insert
    suspend fun insertTip(tip: Tip)

    @Delete
    suspend fun deleteTip(tip: Tip)
}