package br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.themovieandroid.databinding.GenresItemBinding
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail

class GenereAdapter(private val movieSeries: List<MovieSeriesDetail.GenresBean>?,
                    private val context: Context
) : RecyclerView.Adapter<GenereAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: GenresItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MovieSeriesDetail.GenresBean) {
            binding.generesItem = item
            binding.executePendingBindings()
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = GenresItemBinding.inflate(inflater)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return this.movieSeries?.size!!
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(movieSeries!!.get(position))
}