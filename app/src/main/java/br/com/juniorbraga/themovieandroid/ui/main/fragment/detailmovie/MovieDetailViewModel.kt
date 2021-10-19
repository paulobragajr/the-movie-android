package br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie

import android.content.Context
import android.graphics.drawable.Drawable
import android.os.Build
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie.adapter.GenereAdapter
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget


class MovieDetailViewModel() : ViewModel(), MovieDetailContract.ViewModel {

    private val _imageDrawable = MutableLiveData<Drawable>()
    val imageDrawable: LiveData<Drawable> = _imageDrawable

    private val _title = MutableLiveData<String>()
    val title: LiveData<String> = _title

    private val _overview = MutableLiveData<String>()
    val overview: LiveData<String> = _overview

    private val _tagline = MutableLiveData<String>()
    val tagline: LiveData<String> = _tagline

    private val _genereAdapter = MutableLiveData<GenereAdapter>()
    val genereAdapter: LiveData<GenereAdapter> = _genereAdapter

    private val _rating = MutableLiveData<Double>()
    val rating: LiveData<Double> = _rating

    private val _isTagline = MutableLiveData<Boolean>()
    val isTagline: LiveData<Boolean> = _isTagline

    lateinit var context: Context

    override fun updateMovies(movie: MovieSeriesDetail) {
        _title.value = movie.title
        _overview.value = movie.overview
        _tagline.value = movie.tagline
        _rating.value= movie.vote_average
        _isTagline.value = movie.tagline.isNullOrEmpty()
        _genereAdapter.value = GenereAdapter(movie.genres, context)
        movie.backdrop_path?.let { imageDrawable(it) }
    }

    override fun showError(error: String) {

    }

    fun imageDrawable(backdrop_path:String){
        val urlMovie: String = context.getString(R.string.base_url_img_movie) +
                context.getString(R.string.size_imagem_origianl) + backdrop_path

        Glide.with(context).load(urlMovie)
            .into(object : SimpleTarget<Drawable?>() {
                override fun onResourceReady(
                    resource: Drawable,
                    transition: com.bumptech.glide.request.transition.Transition<in Drawable?>?
                ) {
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        _imageDrawable.value = resource
                    }
                }
            })
    }


    override fun setView(
        context: Context,
        presenter: MovieDetailContract.Presenter,
        idMovie:Int
    ) {
        this.context = context

        presenter.setView(this)
        presenter.getMovie(idMovie)
    }
}