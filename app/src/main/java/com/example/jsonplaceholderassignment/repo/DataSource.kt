package com.example.jsonplaceholderassignment.repo

import com.example.jsonplaceholderassignment.model.ViewAlbums
import io.reactivex.Maybe

interface DataSource{
    fun getAlbumsFromList(): Maybe<List<ViewAlbums>>
    fun addAlbumViews(viewAlbums: ViewAlbums)
}