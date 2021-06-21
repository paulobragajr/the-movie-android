package br.com.juniorbraga.themovieandroid.ui.main

import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import io.reactivex.Observable

interface MainContract  {

    interface Model {
        fun getList(page: Int): Observable<ResponseMovieSeries>
    }

    interface View {
        fun selectedMovie(movie:MovieSeries)
        fun updateMovies(moviesList: ResponseMovieSeries)
        fun initialMovie(moviesList: ResponseMovieSeries)
        fun showError(error: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun getListMovies()
        fun stop()
        fun getListMoviesPage(page: Int)
    }
}