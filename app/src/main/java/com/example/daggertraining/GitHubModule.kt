package com.example.daggertraining

import dagger.Module
import dagger.Provides
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path


@Module
class GitHubModule {
    interface GitHubApiInterface {
        @GET("/org/{orgName}/repos")
        fun getRepository(@Path("orgName") orgName: String): Call<List<Repository>>
    }

    @Provides
    @UserScope // needs to be consistent with the component scope
    fun providesGitHubInterface(retrofit: Retrofit): GitHubApiInterface {
        return retrofit.create(GitHubApiInterface::class.java)
    }
}