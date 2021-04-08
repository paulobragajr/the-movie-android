package br.com.juniorbraga.themovieandroid.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.juniorbraga.themovieandroid.R
import kotlinx.android.synthetic.main.the_movie_ratintg.view.*

class TheMovieRating @JvmOverloads
constructor(private val ctx: Context, private val attributeSet: AttributeSet? = null, private val defStyleAttr: Int = 0)
    : ConstraintLayout(ctx, attributeSet, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.the_movie_ratintg, this, true)
    }

    fun setRating(voteAverage: Double){
        rtb_ranking.rating = (voteAverage / 2).toFloat()
        txt_raking.text = voteAverage.toString()
    }
}