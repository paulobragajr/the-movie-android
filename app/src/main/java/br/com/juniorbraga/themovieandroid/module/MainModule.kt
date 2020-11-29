package br.com.juniorbraga.themovieandroid.module

import br.com.juniorbraga.themovieandroid.service.EndPoint
import br.com.juniorbraga.themovieandroid.ui.main.MainContract
import br.com.juniorbraga.themovieandroid.ui.main.MainModel
import br.com.juniorbraga.themovieandroid.ui.main.MainPresenter
import dagger.Module
import dagger.Provides

@Module
class MainModule {

    @Provides
    fun provideMainPresenter(model: MainContract.Model): MainContract.Presenter {
        return MainPresenter(model)
    }

    @Provides
    fun provideMainModel(service: EndPoint): MainContract.Model {
        return MainModel(service)
    }
}