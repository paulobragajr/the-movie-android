package br.com.juniorbraga.themovieandroid.aplication

import android.app.Application
import br.com.juniorbraga.themovieandroid.module.ApplicationModule
import br.com.juniorbraga.themovieandroid.service.APIModuleService
import br.com.juniorbraga.themovieandroid.module.ListMovieModule
import br.com.juniorbraga.themovieandroid.module.MovieDetailModule


class App: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .aPIModuleService(APIModuleService())
            .movieDetailModule(MovieDetailModule())
            .listMovieModule(ListMovieModule())
            .build()
    }

    fun getComponent(): ApplicationComponent {
        return component
    }
}