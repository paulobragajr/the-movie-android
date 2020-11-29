package br.com.juniorbraga.themovieandroid.ui.moviedetail

import io.reactivex.disposables.CompositeDisposable

class MovieDetailPresenter(private var model: MovieDetailContract.Model): MovieDetailContract.Presenter {

    private lateinit var view: MovieDetailContract.View

    private val disposables = CompositeDisposable()

    override fun setView(view: MovieDetailContract.View) {
        this.view = view
    }

    override fun getMovie(idMovie: Int) {

        disposables.add(
                model.getMovie(idMovie)
                        .subscribe(
                                {it -> view.updateMovies(it)},
                                {it -> view.showError(it.message!!)}
                        )
        )
    }

    override fun stop() {
        disposables.clear()
    }
}