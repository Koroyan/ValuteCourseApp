package com.koroyan.valutecourse

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.koroyan.valutecourse.retrofitapi.RetrofitClient
import retrofit2.Retrofit

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        RetrofitClient.get()
    }
}