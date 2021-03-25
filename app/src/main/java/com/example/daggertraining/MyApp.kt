package com.example.daggertraining


import android.app.Application
import com.example.daggertraining.di.AppComponent
import com.example.daggertraining.module.AppModule
import com.example.daggertraining.module.NetModule


class MyApp : Application() {
    var appComponent: AppComponent? = null
        private set

    override fun onCreate() {
        super.onCreate()

        // Dagger%COMPONENT_NAME%
        appComponent =
            DaggerAppComponent.builder() // list of modules that are part of this component need to be created here too
                .appModule(AppModule(this)) // This also corresponds to the name of your module: %component_name%Module
                .netModule(NetModule("https://api.github.com"))
                .build()

        // If a Dagger 2 component does not have any constructor arguments for any of its modules,
        // then we can use .create() as a shortcut instead:
        //  mAppComponent = com.codepath.dagger.components.DaggerAppComponent.create();
    }

}