package com.example.jsonplaceholderassignment.home

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.jsonplaceholderassignment.R
import com.example.jsonplaceholderassignment.model.ViewAlbums

class AlbumsAdapter: RecyclerView.Adapter<AlbumsAdapter.ResultViewHolder>(){

    private val data = mutableListOf<ViewAlbums>()

    fun setData(albums: List<ViewAlbums>?) {
        albums?.let {
            data.clear()
            data.addAll(albums)
            notifyDataSetChanged()
        }
    }
        override fun onCreateViewHolder(parent: ViewGroup, p1: Int): ResultViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view, parent, false)
            return ResultViewHolder(view)
        }

        override fun getItemCount() = data.size

        override fun onBindViewHolder(resultViewHolder: ResultViewHolder, position: Int) {
            resultViewHolder.tvTitle.text = data[position].title.toString()
            resultViewHolder.tvID.text = data[position].id.toString()
            resultViewHolder.tvUserID.text = data[position].userId.toString()
        }

    class ResultViewHolder(view: View): RecyclerView.ViewHolder(view) {
        val tvTitle: TextView = view.findViewById(R.id.tvTitle)
        val tvID: TextView = view.findViewById(R.id.tvID)
        val tvUserID: TextView = view.findViewById(R.id.tvUserID)
    }


}