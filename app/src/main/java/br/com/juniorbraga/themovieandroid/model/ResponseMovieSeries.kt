package br.com.juniorbraga.themovieandroid.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.ArrayList

@Parcelize
data class ResponseMovieSeries (val page: Int,
                                val total_results: Int,
                                val total_pages: Int,
                                val results: List<MovieSeries>) : Parcelable