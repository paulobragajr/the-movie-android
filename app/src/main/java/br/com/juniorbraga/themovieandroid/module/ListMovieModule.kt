package br.com.juniorbraga.themovieandroid.module

import br.com.juniorbraga.themovieandroid.service.EndPoint
import br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie.ListMovieContract
import br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie.ListMovieModel
import br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie.ListMoviePresenter
import dagger.Module
import dagger.Provides

@Module
class ListMovieModule {

    @Provides
    fun provideListMoviePresenter(model: ListMovieContract.Model): ListMovieContract.Presenter {
        return ListMoviePresenter(model)
    }

    @Provides
    fun provideListMovieModel(service: EndPoint): ListMovieContract.Model {
        return ListMovieModel(service)
    }
}