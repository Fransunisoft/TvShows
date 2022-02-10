package com.fransunisoft.tvshows

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fransunisoft.tvshow.models.MovieData
import com.fransunisoft.tvshows.adapter.MoviesAdapter
import com.fransunisoft.tvshows.network.MoviesRepository

class MainActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: MoviesAdapter
    private lateinit var layoutManager: LinearLayoutManager

    private var moviePage = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.top_rated_movies)
        layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        recyclerView.layoutManager = layoutManager
        adapter = MoviesAdapter((mutableListOf()))
        recyclerView.adapter = adapter

        getTopRated()
    }

    private fun getTopRated() {
        MoviesRepository.getTopRatedMovies(
            moviePage,
            onSuccess = ::fetchMovies,
            onError = ::onError
        )
    }

    private fun topRatedScrollListener() {
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                val totalItemCount = layoutManager.itemCount
                val visibleItemCount = layoutManager.childCount
                val firstVisibleItem = layoutManager.findFirstVisibleItemPosition()

                if (firstVisibleItem + visibleItemCount >= totalItemCount / 2) {
                    recyclerView.removeOnScrollListener(this)
                    moviePage++
                    getTopRated()
                }
            }
        })
    }

    private fun fetchMovies(movieData: List<MovieData>) {
        adapter.appendMovies(movieData)
        topRatedScrollListener()
        Log.i("MainActivity", "movieData${movieData}")
    }

    private fun onError() {

    }

}