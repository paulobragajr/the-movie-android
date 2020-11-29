package br.com.juniorbraga.themovieandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieSeries (val adult: Boolean,
                        val backdrop_path: String,
                        val genre_ids: List<Int>,
                        val id: Int,
                        val original_language: String,
                        val original_title: String,
                        val overview: String,
                        val genres: String,
                        val popularity: Double,
                        val poster_path: String,
                        val release_date: String,
                        val title: String,
                        val tagline:String,
                        val video: Boolean,
                        val vote_average: Double,
                        val vote_count: Int): Parcelable