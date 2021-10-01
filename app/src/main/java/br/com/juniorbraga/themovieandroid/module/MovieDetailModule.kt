package br.com.juniorbraga.themovieandroid.module

import br.com.juniorbraga.themovieandroid.service.EndPoint
import br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie.MovieDetailContract
import br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie.MovieDetailModel
import br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie.MovieDetailPresenter
import dagger.Module
import dagger.Provides

@Module
class MovieDetailModule {

    @Provides
    fun provideMovieDetailPresenter(model: MovieDetailContract.Model): MovieDetailContract.Presenter {
        return MovieDetailPresenter(model)
    }

    @Provides
    fun provideMovieDetailModel(service: EndPoint): MovieDetailContract.Model {
        return MovieDetailModel(service)
    }
}