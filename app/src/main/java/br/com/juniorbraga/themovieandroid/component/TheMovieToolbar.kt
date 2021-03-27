package br.com.juniorbraga.themovieandroid.component

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.juniorbraga.themovieandroid.R
import kotlinx.android.synthetic.main.movie_toolbar.view.*

class TheMovieToolbar  @JvmOverloads
constructor(private val ctx: Context, private val attributeSet: AttributeSet? = null, private val defStyleAttr: Int = 0)
    : ConstraintLayout(ctx, attributeSet, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.movie_toolbar, this, true)

        btn_back.setOnClickListener {
            Toast.makeText(context,"teste aquiii",Toast.LENGTH_LONG).show()
        }
    }
}