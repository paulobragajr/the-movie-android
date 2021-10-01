package br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie

import android.graphics.drawable.Drawable
import android.os.Build
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.core.view.isVisible
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.aplication.App
import br.com.juniorbraga.themovieandroid.component.percentView
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie.adapter.GenereAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import kotlinx.android.synthetic.main.detail_movie_fragment.*
import javax.inject.Inject

class MovieDetailFragment : Fragment(), MovieDetailContract.View {

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter
    lateinit var movieSeries: MovieSeriesDetail
    private lateinit var viewModel: MovieDetailViewModel

    val args by navArgs<MovieDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
        (this.activity?.application as App).getComponent()?.inject(this)
        val movieId = args.idMovie
        context?.let { viewModel.setView(this@MovieDetailFragment, it, this.presenter,movieId) }

        val display = activity?.windowManager?.defaultDisplay
        val rlParms: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(display!!.width, percentView(display.height, 70))
        rl_view.layoutParams = rlParms
    }

        override fun updateMovies(movie: MovieSeriesDetail) {
        this.movieSeries = movie

        if (this.movieSeries.tagline.toString().isEmpty())
            txt_tagline.isVisible = false

        txt_title_movie.text = this.movieSeries.title
        txt_overview.text = this.movieSeries.overview
        txt_tagline.text = this.movieSeries.tagline
        rating.setRating(this.movieSeries.vote_average)

        val layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);
        rv_genere.layoutManager = layoutManager
        rv_genere.adapter = context?.let { GenereAdapter(this.movieSeries.genres, it) }

        this.initImage()
    }

    fun initImage() {
        val urlMovie: String = this.getString(R.string.base_url_img_movie) +
                this.getString(R.string.size_imagem_origianl) + this.movieSeries.backdrop_path

        Glide.with(this).load(urlMovie)
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: com.bumptech.glide.request.transition.Transition<in Drawable?>?
                ) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        rl_movie.background = resource
                    }
                }
            })
    }
}