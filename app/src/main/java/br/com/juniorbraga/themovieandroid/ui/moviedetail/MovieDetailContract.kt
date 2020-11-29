package br.com.juniorbraga.themovieandroid.ui.moviedetail

import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import io.reactivex.Observable

interface MovieDetailContract  {

    interface Model {
        fun getMovie(idMovie: Int): Observable<MovieSeriesDetail>
    }

    interface View {
        fun updateMovies(movie: MovieSeriesDetail)
        fun showError(error: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun getMovie(idMovie: Int)
        fun stop()
    }
}