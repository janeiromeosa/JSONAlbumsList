package com.example.jsonplaceholderassignment.home

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.example.jsonplaceholderassignment.R
import com.example.jsonplaceholderassignment.model.ViewAlbums
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private val albumsAdapter = AlbumsAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvData.layoutManager = LinearLayoutManager(this)
        rvData.adapter = albumsAdapter

        val homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        val observer = Observer<List<ViewAlbums>>{
            if (it!= null)
                albumsAdapter.setData(it)
        }

        homeViewModel.getAlbums(application)
        homeViewModel.getAlbumsObservable().observe(this, observer)
    }
}
