package br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie

import br.com.juniorbraga.themovieandroid.component.merge
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import io.reactivex.disposables.CompositeDisposable

class ListMoviePresenter (private var model: ListMovieContract.Model) : ListMovieContract.Presenter {

    private lateinit var viewModel: ListMovieContract.ViewModel
    private lateinit var responseMovieSeries: ResponseMovieSeries
    private val disposables = CompositeDisposable()


    override fun setView(view: ListMovieContract.ViewModel) {
        if (view != null) {
            this.viewModel = view
        }
    }


    override fun getListMovies() {
        disposables.add(
            model.getList(1)
                .subscribe(
                    { it ->
                        responseMovieSeries = it
                        viewModel.initialMovie(responseMovieSeries)
                    },
                    { it -> viewModel.showError(it.message!!) }
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
                        viewModel.updateMovies(responseMovieSeries)
                    },
                    { it -> viewModel.showError(it.message!!) }
                )
        )
    }
}