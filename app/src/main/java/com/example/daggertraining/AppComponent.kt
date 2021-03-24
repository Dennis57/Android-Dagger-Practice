package com.example.daggertraining

import android.content.SharedPreferences
import dagger.Component
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import javax.inject.Named
import javax.inject.Singleton


@Singleton
@Component(modules = [AppModule::class, NetModule::class])
interface AppComponent {
    fun inject(activity: MyActivity)

    // remove injection methods if downstream modules will perform injection
    // downstream components need these exposed
    // the method name does not matter, only the return type
    fun retrofit(): Retrofit
    @Named("cached") fun okHttpClient(): OkHttpClient
    fun sharedPreferences(): SharedPreferences
}