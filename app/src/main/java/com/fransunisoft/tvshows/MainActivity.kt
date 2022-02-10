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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.top_rated_movies)
        recyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        adapter = MoviesAdapter(listOf())
        recyclerView.adapter = adapter

        MoviesRepository.getTopRatedMovies(
            onSuccess = ::fetchMovies,
            onError = ::onError
        )
    }

    private fun fetchMovies(movieData: List<MovieData>) {
        adapter.updateMovie(movieData)
        Log.i("MainActivity", "movieData${movieData}")
    }

    private fun onError() {
        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show()
    }

}