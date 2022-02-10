package com.fransunisoft.tvshows.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterCrop
import com.fransunisoft.tvshow.models.MovieData
import com.fransunisoft.tvshows.R

class MoviesAdapter(private var movieData: List<MovieData>) :
    RecyclerView.Adapter<MoviesAdapter.MovieViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_movie, parent, false)
        return MovieViewHolder(view)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movieData[position])
    }

    override fun getItemCount(): Int = movieData.size

    fun updateMovie(movieData: List<MovieData>) {
        this.movieData = movieData
        notifyDataSetChanged()
    }

    inner class MovieViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val image: ImageView = itemView.findViewById(R.id.movie_image)
        private val name: TextView = itemView.findViewById(R.id.movie_title)
        private val rating: TextView = itemView.findViewById(R.id.movie_rating_text)

        fun bind(movieData: MovieData) {
            Glide.with(itemView)
                .load("https://image.tmdb.org/t/p/w342${movieData.posterPath}")
                .transform(CenterCrop())
                .into(image)

            name.text = movieData.name
            rating.text = itemView.context.getString(R.string.rating, movieData.rating)
        }


    }


}