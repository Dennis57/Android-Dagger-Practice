package com.example.daggertraining

import com.google.gson.annotations.SerializedName

data class Repository(
    @SerializedName("name")
    val name: String? = null,

    @SerializedName("description")
    val description: String? = null
)