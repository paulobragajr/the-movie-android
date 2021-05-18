package br.com.juniorbraga.themovieandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieSeries (val adult: Boolean,
                        val backdrop_path: String,
                        val genre_ids: List<Int>,
                        val original_language: String,
                        val original_title: String,
                        val overview: String,
                        val genres: String,
                        val popularity: Double,
                        val release_date: String,
                        val id: Int,
                        val poster_path: String,
                        val title: String,
                        val vote_average: Double,
                        val tagline:String,
                        val video: Boolean,
                        val vote_count: Int): Parcelable