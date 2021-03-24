package com.example.daggertraining

import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules=[MyActivityModule::class])
interface MyApplicationComponent {
    var newMyActivitySubcomponent: MyApplicationComponent
}