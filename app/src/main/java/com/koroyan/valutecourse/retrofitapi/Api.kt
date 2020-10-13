package com.koroyan.valutecourse.retrofitapi



import com.koroyan.valutecourse.model.RSS
import retrofit2.Call
import retrofit2.http.GET

interface Api {


    @GET("rss.php")
    fun resourcesRequest(
    ): Call<RSS>

}