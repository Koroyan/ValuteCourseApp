package com.koroyan.valutecourse.ui.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.koroyan.valutecourse.R
import com.koroyan.valutecourse.ui.main.MainActivity


class SplashScreenActivity : AppCompatActivity() {
    private var mDelayHandler: Handler? = null

    companion object {
        const val SPLASH_DELAY: Long = 3000
    }

    private val mRunnable: Runnable = Runnable {
        if (!isFinishing) {
            val intent = Intent(applicationContext, MainActivity::class.java)
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_NO_ANIMATION)
            startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        init()
    }

    private fun init() {
        mDelayHandler = Handler(Looper.getMainLooper())
    }

    public override fun onResume() {
        mDelayHandler!!.postDelayed(mRunnable, SPLASH_DELAY)
        super.onResume()
    }


    public override fun onStop() {
        if (mDelayHandler != null) {
            mDelayHandler!!.removeCallbacks(mRunnable)
        }
        super.onStop()
    }

}