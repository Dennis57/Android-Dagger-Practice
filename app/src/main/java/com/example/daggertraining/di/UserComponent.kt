package com.example.daggertraining.di

import com.example.daggertraining.MainActivity
import com.example.daggertraining.UserScope
import com.example.daggertraining.module.GitHubModule
import dagger.Component

@UserScope // using the previously defined scope, note that @Singleton will not work
@Component(dependencies = [AppComponent::class], modules = [GitHubModule::class])
interface UserComponent {
    fun inject(activity: MainActivity)
}