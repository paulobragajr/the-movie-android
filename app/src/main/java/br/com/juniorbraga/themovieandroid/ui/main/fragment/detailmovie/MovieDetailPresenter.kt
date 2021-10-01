package br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie

import io.reactivex.disposables.CompositeDisposable

class MovieDetailPresenter(private var model: MovieDetailContract.Model) :
    MovieDetailContract.Presenter {

    private lateinit var viewModel: MovieDetailContract.ViewModel
    private val disposables = CompositeDisposable()

    override fun setView(view: MovieDetailContract.ViewModel) {
        if (view != null) {
            this.viewModel = view
        }
    }

    override fun getMovie(idMovie: Int) {
        disposables.add(
            model.getMovie(idMovie)
                .subscribe(
                    { it -> viewModel.updateMovies(it) },
                    { it -> viewModel.showError(it.message!!) }
                )
        )
    }

    override fun stop() {
        disposables.clear()
    }
}