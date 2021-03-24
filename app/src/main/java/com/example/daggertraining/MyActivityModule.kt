package com.example.daggertraining

import android.R
import android.widget.ArrayAdapter
import dagger.Module
import dagger.Provides
import javax.inject.Named


@Module
class MyActivityModule(activity: MyActivity) {

    private lateinit var activity: MyActivity

    // must be instantiated with an activity
    fun MyActivityModule(activity: MyActivity) {
        this.activity = activity
    }

    @Provides
    @MyActivityScope
    @Named("my_list")
    fun providesMyListAdapter(): ArrayAdapter<*>? {
        return ArrayAdapter<String>(activity!!, R.layout.my_list)
    }
}