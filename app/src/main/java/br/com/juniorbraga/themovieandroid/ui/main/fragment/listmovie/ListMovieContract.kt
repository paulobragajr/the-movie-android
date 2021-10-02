package br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie

import android.content.Context
import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import io.reactivex.Observable

interface ListMovieContract {

    interface Model {
        fun getList(page: Int): Observable<ResponseMovieSeries>
    }

    interface View {
        fun selectedMovie(movie: MovieSeries)
        fun returnMovies(isUpdate:Boolean,moviesList: ResponseMovieSeries)
    }

    interface ViewModel {
        fun setView(view: View?,context: Context,presenter: Presenter)
        fun updateMovies(moviesList: ResponseMovieSeries)
        fun initialMovie(moviesList: ResponseMovieSeries)
        fun showError(error: String)
        fun getListMovies()
    }

    interface Presenter {
        fun setView(view: ViewModel)
        fun getListMovies()
        fun stop()
        fun getListMoviesPage(page: Int)
    }
}