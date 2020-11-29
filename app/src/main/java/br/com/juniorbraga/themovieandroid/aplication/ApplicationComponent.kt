package br.com.juniorbraga.themovieandroid.aplication

import br.com.juniorbraga.themovieandroid.ui.main.MainActivity
import br.com.juniorbraga.themovieandroid.module.ApplicationModule
import br.com.juniorbraga.themovieandroid.module.MainModule
import br.com.juniorbraga.themovieandroid.module.MovieDetailModule
import br.com.juniorbraga.themovieandroid.service.APIModuleService
import br.com.juniorbraga.themovieandroid.ui.moviedetail.MovieDetailActivity
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Paulo Braga Junior
 * on 2019-05-11.
 */

@Singleton
@Component(modules = [ApplicationModule::class, APIModuleService::class, MainModule::class, MovieDetailModule::class])
interface ApplicationComponent {
    fun inject(activity: MainActivity)
    fun inject(activity: MovieDetailActivity)
}