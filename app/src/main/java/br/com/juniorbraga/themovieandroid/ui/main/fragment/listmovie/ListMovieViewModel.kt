package br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie

import android.content.Context
import android.content.Intent
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.themovieandroid.component.OnLoadMoreListener
import br.com.juniorbraga.themovieandroid.component.RecyclerViewLoadMoreScroll
import br.com.juniorbraga.themovieandroid.component.showSimpleDialog
import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import br.com.juniorbraga.themovieandroid.service.ID_MOVIE
import br.com.juniorbraga.themovieandroid.ui.moviedetail.MovieDetailActivity

class ListMovieViewModel: ViewModel(), ListMovieContract.ViewModel{

    lateinit var presenter: ListMovieContract.Presenter

    var responseMovieSeries = MutableLiveData<ResponseMovieSeries>()
    private lateinit var view: ListMovieContract.View

    lateinit var context: Context
    lateinit var scrollListener: RecyclerViewLoadMoreScroll
    var currentPage: Int = 1
    var INDEX_PAGE = 1

    override fun setView(view: ListMovieContract.View?,context: Context,presenter: ListMovieContract.Presenter) {
        this.context = context

        this.presenter = presenter
        this.presenter.setView(this)
        this.presenter.getListMovies()

        if (view != null) {
            this.view = view
        }
    }

    fun getScrollListener(mLayoutManager: RecyclerView.LayoutManager):RecyclerViewLoadMoreScroll{
        this.scrollListener = RecyclerViewLoadMoreScroll(mLayoutManager as LinearLayoutManager)
        this.scrollListener.setOnLoadMoreListener(object : OnLoadMoreListener {
            override fun onLoadMore() {
                presenter.getListMoviesPage(currentPage)
            }
        })

        return scrollListener
    }
    fun setCurrentpage(){ this.currentPage = this.currentPage + INDEX_PAGE }

    override fun selectedMovie(movie: MovieSeries) {
        val intent = Intent(this.context, MovieDetailActivity::class.java)
        intent.putExtra(ID_MOVIE, movie.id)
        this.context.startActivity(intent)
    }

    override fun updateMovies(moviesList: ResponseMovieSeries) {
        this.setCurrentpage();
        this.scrollListener.setLoaded()
        this.view.returnMovies(true,moviesList)
    }

    override fun initialMovie(moviesList: ResponseMovieSeries) {
        this.setCurrentpage()
        this.view.returnMovies(false,moviesList)
    }

    override fun showError(error: String) {
        showSimpleDialog(this.context,error) { _, _ ->
            this.presenter.getListMovies()
        }
    }

    override fun getListMovies() {
        this.presenter.getListMovies()
    }
}