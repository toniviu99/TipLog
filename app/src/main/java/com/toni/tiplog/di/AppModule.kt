package com.toni.tiplog.di

import android.app.Application
import androidx.room.Room
import com.toni.tiplog.feature_tip.data.local.TipDao
import com.toni.tiplog.feature_tip.data.local.TipDatabase
import com.toni.tiplog.feature_tip.data.repository.TipRepositoryImpl
import com.toni.tiplog.feature_tip.domain.repository.TipRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideTipDatabase(app:Application):TipDatabase{
        return Room.databaseBuilder(
            app,
            TipDatabase::class.java,
            TipDatabase.DATABASE_NAME
        ).build()
    }

    @Provides
    @Singleton
    fun provideTipRepository(db: TipDatabase):TipRepository{
        return TipRepositoryImpl(db.tipDao)
    }
}