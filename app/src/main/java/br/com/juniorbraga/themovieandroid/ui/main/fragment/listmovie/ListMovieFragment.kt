package br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.aplication.App
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import br.com.juniorbraga.themovieandroid.model.MovieSeries
import br.com.juniorbraga.themovieandroid.model.ResponseMovieSeries
import br.com.juniorbraga.themovieandroid.ui.main.fragment.listmovie.adapter.MovieAdapter
import kotlinx.android.synthetic.main.list_movie_fragment.*
import javax.inject.Inject
import androidx.navigation.fragment.findNavController

class ListMovieFragment : Fragment() , ListMovieContract.View{

    @Inject
    lateinit var presenter: ListMovieContract.Presenter
    private lateinit var listMovieViewModel: ListMovieViewModel
    lateinit var adapter: MovieAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.list_movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.listMovieViewModel = ViewModelProvider(this).get(ListMovieViewModel::class.java)
        (this.activity?.application as App).getComponent()?.inject(this)
        this.initRecyclerView()
        context?.let { listMovieViewModel.setView(this@ListMovieFragment,it, this.presenter) }
    }

    private fun initRecyclerView() {
        var mLayoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this.context)
        rv_movie.layoutManager = mLayoutManager
        rv_movie.setHasFixedSize(true)
        rv_movie.addOnScrollListener(this.listMovieViewModel.getScrollListener(mLayoutManager))
    }

    override fun selectedMovie(movie: MovieSeries) {
        findNavController().navigate(ListMovieFragmentDirections.actionDetailMovieFragment(movie.id))
    }

    override fun returnMovies(isUpdate: Boolean, moviesList: ResponseMovieSeries) {
        if(isUpdate){
            this.adapter.updateList(moviesList.results);
        }else{
            adapter = context?.let { MovieAdapter(moviesList.results, it,this@ListMovieFragment) }!!
            rv_movie.adapter = adapter
        }
    }
}