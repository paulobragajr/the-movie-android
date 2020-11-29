package br.com.juniorbraga.themovieandroid.service

import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.MovieSeriesDetail
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.*

interface EndPoint {

    @GET("movie/popular")
    fun getMovie(@Query("api_key") apiKey: String,
                 @Query("page")page:Int): Observable<ResponseMovieSeries>

//    @GET("tv/popular")
//    abstract fun getSeries(@Query("api_key") apiKey: String): Call<ResponseMovieSeries>
//
    @GET("movie/{idMovie}")
     fun detailMovie(
        @Path("idMovie") idMovie: Int,
        @Query("api_key") apiKey: String
    ): Observable<MovieSeriesDetail>
//
//    @GET("tv/{idSerie}")
//    abstract fun detailSerie(
//        @Path("idSerie") idSerie: Long,
//        @Query("api_key") apiKey: String
//    ): Call<MovieSeriesDetail>

//    @GET("movie/popular")
//    fun list(): Observable<ResponseBody>

}