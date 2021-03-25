package com.example.daggertraining.module

import com.example.daggertraining.Repository
import com.example.daggertraining.UserScope
import dagger.Module
import dagger.Provides
import io.reactivex.Observable
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import javax.inject.Singleton


@Module
object GitHubModule {
    interface GitHubApiInterface {
        @GET("/org/{orgName}/repos")
        fun getRepository(@Path("orgName") orgName: String): Observable<List<Repository>>
    }

    @Provides
    @UserScope // needs to be consistent with the component scope
    fun providesGitHubInterface(retrofit: Retrofit): GitHubApiInterface {
        return retrofit.create(GitHubApiInterface::class.java)
    }
}