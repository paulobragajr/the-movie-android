package br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.juniorbraga.themovieandroid.component.RecyclerViewLoadMoreScroll
import br.com.juniorbraga.themovieandroid.component.showSimpleDialog
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie.ListMovieContract

class MovieDetailViewModel : ViewModel(), MovieDetailContract.ViewModel {

    lateinit var presenter: MovieDetailContract.Presenter

    //    var responseMovieSeries = MutableLiveData<ResponseMovieSeries>()
    private lateinit var view: MovieDetailContract.View
    lateinit var context: Context


    override fun updateMovies(movie: MovieSeriesDetail) {
        view.updateMovies(movie)
    }


    override fun showError(error: String) {
        showSimpleDialog(this.context, error) { _, _ -> }
    }

    override fun setView(
        view: MovieDetailContract.View?,
        context: Context,
        presenter: MovieDetailContract.Presenter,
        idMovie:Int
    ) {
        this.context = context
        this.presenter = presenter
        this.presenter.setView(this)

        if (view != null) {
            this.view = view
        }

        this.presenter.getMovie(idMovie)
    }
}