package br.com.juniorbraga.themovieandroid.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import br.com.juniorbraga.themovieandroid.R
import br.com.juniorbraga.themovieandroid.ui.main.MainActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val handle = Handler()
        handle.postDelayed(Runnable { nextPage() }, 3000)
    }

    fun nextPage(){
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}