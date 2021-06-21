package br.com.juniorbraga.themovieandroid.ui.moviedetail

import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import br.com.juniorbraga.themovieandroid.service.API_KEY
import br.com.juniorbraga.themovieandroid.service.EndPoint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class MovieDetailModel(private val service: EndPoint): MovieDetailContract.Model {

    override fun getMovie(idMovie: Int): Observable<MovieSeriesDetail> {

        return service.detailMovie(idMovie,API_KEY,"videos,images")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
    }
}