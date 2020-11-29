package br.com.juniorbraga.themovieandroid.aplication

import android.app.Application
import android.content.Context
import br.com.juniorbraga.themovieandroid.module.ApplicationModule
import br.com.juniorbraga.themovieandroid.module.MainModule
import br.com.juniorbraga.themovieandroid.service.APIModuleService
import br.com.juniorbraga.themovieandroid.aplication.ApplicationComponent
import br.com.juniorbraga.themovieandroid.module.MovieDetailModule


class App: Application() {

    private lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .aPIModuleService(APIModuleService())
            .mainModule(MainModule())
            .movieDetailModule(MovieDetailModule())
            .build()

    }

    fun getComponent(): ApplicationComponent {
        return component
    }
}