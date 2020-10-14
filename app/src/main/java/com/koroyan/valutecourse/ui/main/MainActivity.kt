package com.koroyan.valutecourse.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.util.Log.d
import androidx.recyclerview.widget.LinearLayoutManager
import com.koroyan.valutecourse.R
import com.koroyan.valutecourse.model.Description
import com.koroyan.valutecourse.model.RSS
import com.koroyan.valutecourse.repository.CustomCallBack
import com.koroyan.valutecourse.repository.ValuteRepository
import com.koroyan.valutecourse.utils.CustomHtmlParser
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var valuteAdapter: ValuteAdapter
    private lateinit var linearLayoutManager: LinearLayoutManager
    private lateinit var descriptions: ArrayList<Description>
    private var searchText = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        getValuteData()
        searchListener()
        swipeRefreshListener()
    }

    private fun init() {
        descriptions = arrayListOf()
        valuteAdapter = ValuteAdapter()
        linearLayoutManager = LinearLayoutManager(this)
        recyclerView.apply {
            layoutManager = linearLayoutManager
            adapter = valuteAdapter
        }

    }

    private fun getValuteData() {
        ValuteRepository().getValute(object : CustomCallBack {
            override fun onResponse(result: RSS) {
                val description = result.channel.item.description
                descriptions = CustomHtmlParser.tableParseToDescription(description)
                valuteAdapter.setData(descriptions)
                timeTextView.text = result.channel.lastBuildDate
                search(searchText)
            }

            override fun onFailure(error: String) {
                d("infoinfo", error)
            }

        })
    }

    private fun searchListener() {
        searchEditText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                searchText = s.toString()
                search(searchText)
            }

            override fun afterTextChanged(s: Editable?) {
            }

        })
    }

    fun search(text: String) {
        val list = ArrayList<Description>()
        for (it in descriptions) {
            if (it.description!!.contains(text))
                list.add(it)
        }
        valuteAdapter.setData(list)
    }

    private fun swipeRefreshListener() {
        swipeRefreshLayout?.setOnRefreshListener {
            swipeRefreshLayout?.isRefreshing = true
            Handler(Looper.getMainLooper()).postDelayed({
                descriptions.clear()
                valuteAdapter.setData(descriptions)
                getValuteData()
                swipeRefreshLayout?.isRefreshing = false
            }, 500)
        }
    }
}