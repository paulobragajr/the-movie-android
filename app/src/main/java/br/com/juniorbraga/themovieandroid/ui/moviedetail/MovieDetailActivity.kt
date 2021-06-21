package br.com.juniorbraga.themovieandroid.ui.moviedetail

import android.graphics.drawable.Drawable
import android.os.Build
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.aplication.App
import br.com.juniorbraga.themovieandroid.component.percentView
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import br.com.juniorbraga.themovieandroid.service.ID_MOVIE
import br.com.juniorbraga.themovieandroid.ui.moviedetail.adapter.GenereAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject


class MovieDetailActivity : AppCompatActivity(), MovieDetailContract.View {

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter
    lateinit var movieSeries: MovieSeriesDetail

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        val movieId = intent.getIntExtra(ID_MOVIE, 0)

        (this.application as App).getComponent()?.inject(this)

        val display = windowManager.defaultDisplay
        val rlParms: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(display.width, percentView(display.height, 70))
        rl_view.layoutParams = rlParms

        this.presenter.setView(this)
        this.presenter.getMovie(movieId)

    }

    override fun updateMovies(movie: MovieSeriesDetail) {
        this.movieSeries = movie

        if (this.movieSeries.tagline.toString().isEmpty())
            txt_tagline.isVisible = false

        txt_title_movie.text = this.movieSeries.title
        txt_overview.text = this.movieSeries.overview
        txt_tagline.text = this.movieSeries.tagline
        rating.setRating(this.movieSeries.vote_average)

        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rv_genere.layoutManager = layoutManager
        rv_genere.adapter = GenereAdapter(this.movieSeries.genres, this)

        this.initImage()
    }

    fun initImage() {
        val urlMovie: String = this.getString(R.string.base_url_img_movie) +
                this.getString(R.string.size_imagem_origianl) + this.movieSeries.backdrop_path

        val urlMovieProduct: String = this.getString(R.string.base_url_img_movie) +
                this.getString(R.string.size_imagem_origianl) + (this.movieSeries.production_companies?.get(
            0
        )?.logo_path)

        Glide.with(this).load(urlMovieProduct)
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: com.bumptech.glide.request.transition.Transition<in Drawable?>?
                ) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        img_product.setImageDrawable(resource)
                    }
                }
            })
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

    override fun showError(error: String) {

    }
}