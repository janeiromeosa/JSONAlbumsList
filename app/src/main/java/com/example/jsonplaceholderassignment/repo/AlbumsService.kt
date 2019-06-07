package com.example.jsonplaceholderassignment.repo

import com.example.jsonplaceholderassignment.model.ViewAlbums
import com.example.jsonplaceholderassignment.util.ENDPOINT
import io.reactivex.Maybe
import retrofit2.http.GET

interface AlbumsService {
    @GET(ENDPOINT)
    fun getAlbums(): Maybe<List<ViewAlbums>>
}