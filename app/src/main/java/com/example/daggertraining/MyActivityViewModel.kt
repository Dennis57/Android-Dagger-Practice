package com.example.daggertraining

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.daggertraining.module.GitHubModule
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import java.lang.Exception
import javax.inject.Inject

@MyActivityScope
class MyActivityViewModel : ViewModel() {
    private val _data = MutableLiveData<List<Repository>>()

    val data: LiveData<List<Repository>>
        get() =_data

    init {
        getRepositoryData()
    }

    @Inject
    lateinit var mGitHubApiInterface: GitHubModule.GitHubApiInterface

    private fun getRepositoryData() {
        try {
            val disposable = mGitHubApiInterface.getRepository(1)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe({
                        _data.value = it
                    }, {
                        Log.e("<e>", "Error:" + it.message)
                    })
        } catch (e: Exception) {
            Log.e("<e>", "Error:" + e.message)
        }
    }
}