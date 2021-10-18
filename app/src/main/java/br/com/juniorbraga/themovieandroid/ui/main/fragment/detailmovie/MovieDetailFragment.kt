package br.com.juniorbraga.themovieandroid.ui.main.fragment.detailmovie

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.juniorbraga.themovieandroid.aplication.App
import br.com.juniorbraga.themovieandroid.component.percentView
import br.com.juniorbraga.themovieandroid.databinding.DetailMovieFragmentBinding
import kotlinx.android.synthetic.main.detail_movie_fragment.*
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter
    lateinit var moviDetailViewModel: MovieDetailViewModel

    private var _binding: DetailMovieFragmentBinding? = null

    private val binding get() = _binding!!
    val args by navArgs<MovieDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding  = DetailMovieFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.moviDetailViewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
        (this.activity?.application as App).getComponent()?.inject(this)
        binding.apply {
            lifecycleOwner = this@MovieDetailFragment
            viewmodel =moviDetailViewModel

        }
        val movieId = args.idMovie
        context?.let { moviDetailViewModel.setView( it,presenter, movieId) }

        val display = activity?.windowManager?.defaultDisplay
        val rlParms: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(display!!.width, percentView(display.height, 70))
        rl_view.layoutParams = rlParms
        moviDetailViewModel.rating.observe(viewLifecycleOwner) {rating.setRating(it)}
        moviDetailViewModel.genereAdapter.observe(viewLifecycleOwner) {
            val layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);
            rv_genere.layoutManager = layoutManager
            rv_genere.adapter = it
        }
    }
}