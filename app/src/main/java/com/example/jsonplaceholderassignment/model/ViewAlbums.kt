package com.example.jsonplaceholderassignment.model

import com.google.gson.annotations.SerializedName
import java.util.Comparator

data class ViewAlbums(
    @SerializedName("id")
    val id: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("userId")
    val userId: Int)