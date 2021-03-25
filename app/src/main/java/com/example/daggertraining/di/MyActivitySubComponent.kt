package com.example.daggertraining.di

import com.example.daggertraining.MyActivity
import com.example.daggertraining.MyActivityScope
import com.example.daggertraining.module.MyActivityModule
import dagger.Subcomponent

@MyActivityScope
@Subcomponent(modules=[MyActivityModule::class])
interface MyActivitySubComponent {
    fun inject(activity: MyActivity)

    @Subcomponent.Builder
    interface Builder : SubcomponentBuilder<MyActivitySubComponent> {
        fun activityModule(module: MyActivityModule): Builder
    }
}

interface SubcomponentBuilder<V> {
    fun build(): V
}