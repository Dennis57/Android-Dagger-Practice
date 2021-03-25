package com.example.daggertraining.di

import com.example.daggertraining.module.MyActivityModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[MyActivityModule::class])
interface MyApplicationComponent {
    var newMyActivitySubcomponent: MyApplicationComponent
}