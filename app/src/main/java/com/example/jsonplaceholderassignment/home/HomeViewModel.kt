package com.example.jsonplaceholderassignment.home

import android.app.Application
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.jsonplaceholderassignment.model.ViewAlbums
import com.example.jsonplaceholderassignment.repo.AlbumsRepository
import com.example.jsonplaceholderassignment.repo.DataSource
import com.example.jsonplaceholderassignment.repo.RemoteDataSource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class HomeViewModel: ViewModel(){
    private val albumsObservable: MutableLiveData<List<ViewAlbums>> = MutableLiveData()

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    fun getAlbumsObservable(): LiveData<List<ViewAlbums>> = albumsObservable

    private lateinit var repository: DataSource

    fun getAlbums(application: Application){
        repository = AlbumsRepository(remoteDataSource = RemoteDataSource())

        compositeDisposable.add(repository.getAlbumsFromList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                albumsObservable.value = it
            }, {
                it.printStackTrace()
            }))
    }
}