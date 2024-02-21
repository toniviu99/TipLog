package com.toni.tiplog.feature_tip.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.toni.tiplog.feature_tip.data.local.entity.TipEntity
@Database(
    entities = [TipEntity::class],
    version = 1
)
abstract class TipDatabase: RoomDatabase() {
    abstract val tipDao: TipDao

    companion object{
        const val DATABASE_NAME = "tips_db"
    }
}