package br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.component.FadeInLinearLayoutManager
import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie.ListMovieContract
import com.bumptech.glide.Glide
import kotlinx.android.synthetic.main.movie_item.view.*

class MovieAdapter(private var movieSeries: List<MovieSeries>,
                   private val context: Context,
                   private val view: ListMovieContract.View
) : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleMovie = itemView.txt_title_movie
        val ivMovie = itemView.iv_movie
        val itemRating = itemView.item_rating
        val constItem = itemView.const_item
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.movie_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return this.movieSeries.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val movie = movieSeries[position]

        val urlMovie: String = this.context.getString(R.string.base_url_img_movie) +
                this.context.getString(R.string.size_imagem_185) +
                movie.poster_path

        Glide.with(context)
            .load(urlMovie)
            .into(holder.ivMovie)

        holder.constItem.setOnClickListener { view.selectedMovie(movie) }
        holder.titleMovie.text= movie.title
        holder.itemRating.setRating(movie.vote_average)

        FadeInLinearLayoutManager.animateItemView(holder.itemView)
    }

    fun updateList(results: List<MovieSeries>) {
        this.movieSeries = results
        notifyDataSetChanged()
    }
}