package com.koroyan.valutecourse.repository

import com.koroyan.valutecourse.model.RSS
import com.koroyan.valutecourse.retrofitapi.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ValuteRepository {
    fun getValute(customCallBack: CustomCallBack) {
        RetrofitClient.instance.resourcesRequest().enqueue(object : Callback<RSS> {
            override fun onResponse(call: Call<RSS>, response: Response<RSS>) {
                if (response.isSuccessful) {
                    customCallBack.onResponse(response.body()!!)
                } else {
                    customCallBack.onFailure(response.errorBody()!!.string())
                }
            }

            override fun onFailure(call: Call<RSS>, t: Throwable) {
                customCallBack.onFailure(t.message.toString())
            }

        })
    }
}