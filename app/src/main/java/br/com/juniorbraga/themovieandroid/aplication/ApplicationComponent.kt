package br.com.juniorbraga.themovieandroid.aplication

import br.com.juniorbraga.themovieandroid.module.ApplicationModule
import br.com.juniorbraga.themovieandroid.module.ListMovieModule
import br.com.juniorbraga.themovieandroid.module.MovieDetailModule
import br.com.juniorbraga.themovieandroid.service.APIModuleService
import br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie.MovieDetailFragment
import br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie.ListMovieFragment
import dagger.Component
import javax.inject.Singleton

/**
 * Created by Paulo Braga Junior
 * on 2019-05-11.
 */

@Singleton
@Component(modules = [ApplicationModule::class, APIModuleService::class, MovieDetailModule::class, ListMovieModule::class])
interface ApplicationComponent {
    fun inject(fragment: ListMovieFragment)
    fun inject(fragment: MovieDetailFragment)
}