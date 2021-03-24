package com.example.daggertraining

import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import okhttp3.OkHttpClient
import javax.inject.Inject
import javax.inject.Named


class MainActivity : AppCompatActivity() {

    @Inject @Named("cached")
    lateinit var client: OkHttpClient

    @Inject @Named("non_cached")
    lateinit var client2: OkHttpClient

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (application as MyApp).appComponent!!.inject(this)
    }
}