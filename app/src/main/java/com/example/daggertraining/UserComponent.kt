package com.example.daggertraining

import dagger.Component

@UserScope // using the previously defined scope, note that @Singleton will not work
@Component(dependencies = [AppComponent::class], modules = [GitHubModule::class])
interface UserComponent {
    fun inject(activity: MainActivity)
}