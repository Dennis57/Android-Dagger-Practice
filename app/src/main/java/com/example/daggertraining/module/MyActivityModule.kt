package com.example.daggertraining.module

import android.R
import android.widget.ArrayAdapter
import com.example.daggertraining.MyActivity
import com.example.daggertraining.MyActivityScope
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
        return ArrayAdapter<String>(activity!!, R.layout.activity_list_item)
    }
}