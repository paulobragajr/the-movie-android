package br.com.juniorbraga.themovieandroid.ui.moviedetail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import kotlinx.android.synthetic.main.genres_item.view.*

class GenereAdapter(private val movieSeries: List<MovieSeriesDetail.GenresBean>?,
                    private val context: Context
) : RecyclerView.Adapter<GenereAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var txtGenre = itemView.txt_genre
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.genres_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.movieSeries?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val genere = movieSeries?.get(position)
        holder.txtGenre.text = genere!!.name
    }
}