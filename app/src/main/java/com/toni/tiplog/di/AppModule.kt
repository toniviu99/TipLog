package com.toni.tiplog.di

import android.app.Application
import androidx.room.Room
import com.toni.tiplog.feature_tip.data.local.TipDatabase
import com.toni.tiplog.feature_tip.data.repository.TipRepositoryImpl
import com.toni.tiplog.feature_tip.domain.repository.TipRepository
import com.toni.tiplog.feature_tip.domain.usecase.AddTipUseCase
import com.toni.tiplog.feature_tip.domain.usecase.DeleteTipUseCase
import com.toni.tiplog.feature_tip.domain.usecase.GetMonthsUseCase
import com.toni.tiplog.feature_tip.domain.usecase.GetTipsByMonthUseCase
import com.toni.tiplog.feature_tip.domain.usecase.GetTipsUseCase
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

    @Singleton
    @Provides
    fun provideAddTipUseCase(repository: TipRepository):AddTipUseCase {
        return AddTipUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetTipsUseCase(repository: TipRepository):GetTipsUseCase {
        return GetTipsUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetMonthsUseCase(repository: TipRepository):GetMonthsUseCase {
        return GetMonthsUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideGetTipsByMonthUseCase(repository: TipRepository):GetTipsByMonthUseCase {
        return GetTipsByMonthUseCase(repository)
    }

    @Singleton
    @Provides
    fun provideDeleteTipUseCase(repository: TipRepository):DeleteTipUseCase {
        return DeleteTipUseCase(repository)
    }
}