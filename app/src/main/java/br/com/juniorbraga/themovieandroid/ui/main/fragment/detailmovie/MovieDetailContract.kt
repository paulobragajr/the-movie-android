package br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie

import android.content.Context
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import io.reactivex.Observable

interface MovieDetailContract  {

    interface Model {
        fun getMovie(idMovie: Int): Observable<MovieSeriesDetail>
    }

    interface View {
        fun updateMovies(movie: MovieSeriesDetail)
    }

    interface Presenter {
        fun setView(view: ViewModel)
        fun getMovie(idMovie: Int)
        fun stop()
    }

    interface ViewModel {
        fun updateMovies(movie: MovieSeriesDetail)
        fun showError(error: String)
        fun setView(view: View?, context: Context, presenter: Presenter,idMovie:Int)
    }
}