package br.com.juniorbraga.themovieandroid.component

import android.animation.AnimatorSet
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.view.View
import android.view.animation.AnticipateOvershootInterpolator

open class FadeInLinearLayoutManager  {

    companion object {
        fun animateItemView(itemView: View) {
            //hide the itemView
            itemView.alpha = 0f

            //moving the itemView down 400f
            ObjectAnimator.ofFloat(itemView, "translationY", 0f, 400f)
                .apply { duration = 1L }.start()

            //show
            //itemView.alpha = 1f

            //moving the itemView up 400f
            val translateUp = ObjectAnimator.ofFloat(itemView, "translationY", 400f, 0f)
                .apply {
                    duration = 1000L
                    interpolator = AnticipateOvershootInterpolator(2f)
                }

            //animating alpha
            val fade = ValueAnimator.ofFloat(0f, 1f)
                .apply {
                    addUpdateListener {
                        itemView.alpha = this.animatedValue as Float
                    }
                    duration = 400L
                }

            //applying
            AnimatorSet().apply { playTogether(translateUp, fade) }.start()
        }
    }
}
