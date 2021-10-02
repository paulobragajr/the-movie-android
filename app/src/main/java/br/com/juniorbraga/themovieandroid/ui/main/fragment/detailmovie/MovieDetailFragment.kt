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
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.aplication.App
import br.com.juniorbraga.themovieandroid.component.percentView
import kotlinx.android.synthetic.main.detail_movie_fragment.*
import javax.inject.Inject

class MovieDetailFragment : Fragment() {

    @Inject
    lateinit var presenter: MovieDetailContract.Presenter
    lateinit var viewModel: MovieDetailViewModel

    val args by navArgs<MovieDetailFragmentArgs>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.detail_movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        this.viewModel = ViewModelProvider(this).get(MovieDetailViewModel::class.java)
        (this.activity?.application as App).getComponent()?.inject(this)
        val movieId = args.idMovie
        context?.let { viewModel.setView( it,presenter, movieId) }

        val display = activity?.windowManager?.defaultDisplay
        val rlParms: LinearLayout.LayoutParams =
            LinearLayout.LayoutParams(display!!.width, percentView(display.height, 70))
        rl_view.layoutParams = rlParms

        viewModel.overview.observe(viewLifecycleOwner) { txt_overview.text = it }
        viewModel.title.observe(viewLifecycleOwner) { txt_title_movie.text = it }
        viewModel.tagline.observe(viewLifecycleOwner) { txt_tagline.text = it }
        viewModel.rating.observe(viewLifecycleOwner) {rating.setRating(it)}
        viewModel.genereAdapter.observe(viewLifecycleOwner) {
            val layoutManager =
                LinearLayoutManager(this.context, LinearLayoutManager.HORIZONTAL, false);
            rv_genere.layoutManager = layoutManager
            rv_genere.adapter = it
        }
        viewModel.imageDrawable.observe(viewLifecycleOwner) {
            rl_movie.background = it
        }
    }
}