package br.com.juniorbraga.themovieandroid.ui.main

import io.reactivex.disposables.CompositeDisposable

class MainPresenter(private var model: MainContract.Model): MainContract.Presenter {

    private lateinit var view: MainContract.View

    private val disposables = CompositeDisposable()

    override fun setView(view: MainContract.View) {
        this.view = view
    }

    override fun getListMovies() {

        disposables.add(
            model.getList(1)
                .subscribe(
                    {it -> view.updateMovies(it)},
                    {it -> view.showError(it.message!!)}
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
                                {it -> view.updateMovies(it)},
                                {it -> view.showError(it.message!!)}
                        )
        )
    }
}