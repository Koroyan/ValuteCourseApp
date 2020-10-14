package com.koroyan.valutecourse.retrofitapi

import android.util.Log
import android.util.Log.d
import com.koroyan.valutecourse.model.RSS
import com.koroyan.valutecourse.utils.CustomHtmlParser
import org.json.JSONArray
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import org.w3c.dom.Document
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory


object RetrofitClient {


    private val retrofit = Retrofit.Builder()
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .baseUrl(EndPoints.BASE_URL)
        .build()

    val instance = retrofit.create(Api::class.java)

    fun get() {
        instance.resourcesRequest().enqueue(object : Callback<RSS> {
            override fun onResponse(call: Call<RSS>, response: Response<RSS>) {

            }

            override fun onFailure(call: Call<RSS>, t: Throwable) {
                d("infoinfo", t.message.toString())
            }

        })
    }


}