package com.toni.tiplog.feature_tip.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.toni.tiplog.feature_tip.data.local.entity.TipEntity
import com.toni.tiplog.feature_tip.domain.model.Tip

@Database(
    entities = [Tip::class],
    version = 1
)
abstract class TipDatabase: RoomDatabase() {
    abstract val tipDao: TipDao

    companion object{
        const val DATABASE_NAME = "tips_db"
    }
}