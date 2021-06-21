package br.com.juniorbraga.themovieandroid.ui.main

import br.com.juniorbraga.themovieandroid.component.merge
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import io.reactivex.disposables.CompositeDisposable

class MainPresenter(private var model: MainContract.Model) : MainContract.Presenter {

    private lateinit var view: MainContract.View
    private lateinit var responseMovieSeries: ResponseMovieSeries
    private val disposables = CompositeDisposable()

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun getListMovies() {
        disposables.add(
            model.getList(1)
                .subscribe(
                    { it ->
                        responseMovieSeries = it
                        view.initialMovie(responseMovieSeries)
                    },
                    { it -> view.showError(it.message!!) }
                )
        )
    }

    override fun stop() {
        disposables.clear()
    }

    override fun getListMoviesPage(page: Int) {
        disposables.add(
            model.getList(page)
                .subscribe(
                    { it ->
                        responseMovieSeries.page = it.page
                        responseMovieSeries.results = merge(responseMovieSeries.results, it.results)
                        view.updateMovies(responseMovieSeries)
                    },
                    { it -> view.showError(it.message!!) }
                )
        )
    }
}