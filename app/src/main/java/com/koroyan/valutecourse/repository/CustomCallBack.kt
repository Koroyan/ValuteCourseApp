package com.koroyan.valutecourse.repository

import com.koroyan.valutecourse.model.RSS

interface CustomCallBack {
    fun onResponse(result: RSS)
    fun onFailure(error: String)
}