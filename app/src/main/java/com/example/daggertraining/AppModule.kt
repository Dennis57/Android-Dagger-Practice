package com.example.daggertraining

import android.app.Application
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule(application: Application) {

    private lateinit var mApplication: Application

    fun AppModule(application: Application) {
        mApplication = application
    }

    @Provides
    @Singleton
    fun providesApplication() : Application {
        return mApplication
    }
}