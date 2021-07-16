package br.com.juniorbraga.themovieandroid.ui.main

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Switch
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.aplication.App
import br.com.juniorbraga.themovieandroid.component.OnLoadMoreListener
import br.com.juniorbraga.themovieandroid.component.RecyclerViewLoadMoreScroll
import br.com.juniorbraga.themovieandroid.component.showSimpleDialog
import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import br.com.juniorbraga.themovieandroid.service.ID_MOVIE
import br.com.juniorbraga.themovieandroid.ui.main.adapter.MovieAdapter
import br.com.juniorbraga.themovieandroid.ui.moviedetail.MovieDetailActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() , MainContract.View ,View.OnClickListener{

    @Inject
    lateinit var presenter: MainContract.Presenter
    lateinit var adapter: MovieAdapter
    lateinit var scrollListener: RecyclerViewLoadMoreScroll

    var currentPage: Int = 1
    var INDEX_PAGE = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (this.application as App).getComponent()?.inject(this)

        this.presenter.setView(this)
        this.presenter.getListMovies()

        iv_settings.setOnClickListener(this)
        this.initRecyclerView()
    }

    private fun initRecyclerView() {
        var mLayoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        rv_movie.layoutManager = mLayoutManager
        rv_movie.setHasFixedSize(true)

        this.scrollListener = RecyclerViewLoadMoreScroll(mLayoutManager as LinearLayoutManager)
        this.scrollListener.setOnLoadMoreListener(object : OnLoadMoreListener {
            override fun onLoadMore() {
                presenter.getListMoviesPage(currentPage)
            }
        })
        rv_movie.addOnScrollListener(this.scrollListener)
    }

    fun setCurrentpage(){ this.currentPage = this.currentPage + INDEX_PAGE }

    override fun selectedMovie(movie: MovieSeries) {
        val intent = Intent(this, MovieDetailActivity::class.java)
        intent.putExtra(ID_MOVIE, movie.id)
        startActivity(intent)
    }

    override fun updateMovies(moviesList: ResponseMovieSeries) {
        this.setCurrentpage();
        this.scrollListener.setLoaded()
        this.adapter.updateList(moviesList.results);
    }

    override fun initialMovie(moviesList: ResponseMovieSeries) {
        this.setCurrentpage()
        this.adapter = MovieAdapter(moviesList.results, this,this)
        rv_movie.adapter = this.adapter
    }

    override fun showError(error: String) {
        showSimpleDialog(this,error) { _, _ ->
            this.presenter.getListMovies()
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.iv_settings -> Toast.makeText(this,"Em Construção",Toast.LENGTH_LONG).show()
            else -> { // Note the block
                print("Algo Deu Errado")
            }
        }
    }
}
