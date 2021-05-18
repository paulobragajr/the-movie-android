package br.com.juniorbraga.themovieandroid.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import br.com.juniorbraga.themovieandroid.model.MovieSeriesFavorite

/**
 *
 * @project The Movie Android
 * @author juniorbraga on 5/17/21.
 *
 **/
@Dao
open interface MovieSeriesFavoriteDAO {
    @Insert
    fun addData(favoriteList: MovieSeriesFavorite?)

    @Query("select * from MovieSeriesFavorite")
    fun getFavoriteData(): List<MovieSeriesFavorite?>?

    @Query("SELECT EXISTS (SELECT 1 FROM MovieSeriesFavorite WHERE id=:id)")
    fun isFavorite(id: Int): Int

    @Delete
    fun delete(favoriteList: MovieSeriesFavorite?)
}
