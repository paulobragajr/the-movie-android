package br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie

import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import br.com.juniorbraga.themovieandroid.service.API_KEY
import br.com.juniorbraga.themovieandroid.service.EndPoint
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class ListMovieModel (private val service: EndPoint): ListMovieContract.Model {

    override fun getList(page:Int): Observable<ResponseMovieSeries> {
        return service.getMovie(API_KEY,page)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
    }
}