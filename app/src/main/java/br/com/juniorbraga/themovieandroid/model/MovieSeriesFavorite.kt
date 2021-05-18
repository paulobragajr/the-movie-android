package br.com.juniorbraga.themovieandroid.model

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * @author juniorbraga on 5/17/21.
 * @project The Movie Android
 **/
@Entity(tableName="MovieSeriesFavorite")
data class MovieSeriesFavorite(
    @PrimaryKey var id: Int,
    @ColumnInfo(name = "poster_path") var poster_path: String,
    @ColumnInfo(name = "title")  var title: String,
    @ColumnInfo(name = "vote_average") var vote_average: Double
)


