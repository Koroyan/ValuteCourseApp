package com.koroyan.valutecourse.utils

import android.util.Log
import android.util.Log.d
import com.koroyan.valutecourse.model.Description
import org.json.JSONArray
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.select.Elements

object CustomHtmlParser {
    fun tableParseToDescription(html:String):List<Description>{
        var descriptions = ArrayList<Description>()
        val doc: org.jsoup.nodes.Document? = Jsoup.parse(html)
        val jsonObject = JSONObject()
        val list = JSONArray()
        val elementsByTag: Elements? = doc?.getElementsByTag("tr")
        d("infoinfo", elementsByTag.toString())
        if (elementsByTag != null) {
            for (row in elementsByTag) {
                val valute: String = row.getElementsByTag("td")[0].text()
                val description: String = row.getElementsByTag("td")[1].text()
                val course: String = row.getElementsByTag("td")[2].text()
                var statusGif: String = row.getElementsByTag("td")[3].toString()
                statusGif=statusGif.substring(14,statusGif.length-7)
                    //row.getElementsByTag("td")[3].text()
                val changed: String = row.getElementsByTag("td")[4].text()
               descriptions.add(Description(valute,description,course,statusGif,changed))
               // d("infoinfo",description)
            }
        }
        return descriptions
    }
}