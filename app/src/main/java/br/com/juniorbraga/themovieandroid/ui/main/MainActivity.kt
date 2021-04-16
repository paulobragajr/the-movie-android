package br.com.juniorbraga.themovieandroid.ui.main

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.aplication.App
import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import br.com.juniorbraga.themovieandroid.service.ID_MOVIE
import br.com.juniorbraga.themovieandroid.ui.main.adapter.MovieAdapter
import br.com.juniorbraga.themovieandroid.ui.moviedetail.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() , MainContract.View {

    @Inject
    lateinit var presenter: MainContract.Presenter
    lateinit var responseMovieSeries:ResponseMovieSeries
    lateinit var results: List<MovieSeries>

    var loading = true
    var pastVisiblesItems: Int = 0
    var visibleItemCount: Int = 0
    var totalItemCount: Int = 0
    var currentPage: Int = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (this.application as App).getComponent()?.inject(this)

        this.presenter.setView(this)
        this.presenter.getListMovies()
    }

    override fun selectedMovie(movie: MovieSeries) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(ID_MOVIE, movie.id)
        startActivity(intent)
    }

    override fun updateMovies(moviesList: ResponseMovieSeries) {
        var INITIAL_PAGE = 1
        this.responseMovieSeries =  moviesList
        val layoutManager = LinearLayoutManager(this)

        if (this.currentPage > INITIAL_PAGE){
            this.results = merge(this.results,this.responseMovieSeries.results)
        }else{
            this.results = moviesList.results
        }

        this.currentPage = currentPage + INITIAL_PAGE
        rv_movie.adapter = MovieAdapter(results, this,this)
        rv_movie.layoutManager = layoutManager

        rv_movie.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0) { //check for scroll down
                    visibleItemCount = layoutManager.getChildCount()
                    totalItemCount = layoutManager.getItemCount()
                    pastVisiblesItems = layoutManager.findFirstVisibleItemPosition()

                    if (loading) {
                        if (visibleItemCount + pastVisiblesItems >= totalItemCount) {
                            loading = false

                            if(currentPage <= moviesList.total_pages)
                                presenter.getListMoviesPage(currentPage)
                            loading = true
                        }
                    }
                }
            }
        })
    }


    fun <T> merge(first: List<T>, second: List<T>): List<T> {
        val list: MutableList<T> = ArrayList()
        list.addAll(first!!)
        list.addAll(second!!)
        return list
    }

    override fun showError(error: String) {
        var alertDialog = AlertDialog.Builder(this)
        alertDialog.setTitle("Error")
        alertDialog.setMessage(error)
        alertDialog.setPositiveButton("OK", { _, _ -> })
        alertDialog.setNegativeButton("Repetir", { _, _ ->
            this.presenter.getListMovies()
        })
        alertDialog.show()
    }
}
