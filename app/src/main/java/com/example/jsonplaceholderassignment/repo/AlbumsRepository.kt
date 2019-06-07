package com.example.jsonplaceholderassignment.repo

import com.example.jsonplaceholderassignment.model.ViewAlbums
import io.reactivex.Maybe

class AlbumsRepository(private val remoteDataSource: DataSource): DataSource {

    override fun addAlbumViews(viewAlbums: ViewAlbums) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun getAlbumsFromList(): Maybe<List<ViewAlbums>> {

        return remoteDataSource.getAlbumsFromList()
            .doOnSuccess{getAlbumsFromList()}
    }
}