package br.com.juniorbraga.themovieandroid.component

import android.app.Activity
import android.content.Context
import android.content.ContextWrapper
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import br.com.juniorbraga.themovieandroid.R
import kotlinx.android.synthetic.main.movie_toolbar.view.*

class TheMovieToolbar  @JvmOverloads
constructor(private val ctx: Context, private val attributeSet: AttributeSet? = null, private val defStyleAttr: Int = 0)
    : ConstraintLayout(ctx, attributeSet, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.movie_toolbar, this, true)
        btn_back.setOnClickListener {
            getActivity(context)?.finish()
        }
    }

    /**
     * Get activity instance from desired context.
     */
    fun getActivity(context: Context?): Activity? {
        if (context == null) return null
        if (context is Activity) return context
        return if (context is ContextWrapper) getActivity(context.baseContext) else null
    }
}