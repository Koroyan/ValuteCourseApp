package com.koroyan.valutecourse.utils


import com.koroyan.valutecourse.model.Description
import org.jsoup.Jsoup
import org.jsoup.select.Elements

object CustomHtmlParser {
    fun tableParseToDescription(html: String): ArrayList<Description> {
        val descriptions = ArrayList<Description>()
        val doc: org.jsoup.nodes.Document? = Jsoup.parse(html)
        val elementsByTag: Elements? = doc?.getElementsByTag("tr")
        if (elementsByTag != null) {
            for (row in elementsByTag) {
                val valute: String = row.getElementsByTag("td")[0].text()
                val description: String = row.getElementsByTag("td")[1].text()
                val course: String = row.getElementsByTag("td")[2].text()
                var statusGif: String = row.getElementsByTag("td")[3].toString()
                statusGif = statusGif.substring(14, statusGif.length - 7)
                val changed: String = row.getElementsByTag("td")[4].text()
                descriptions.add(Description(valute, description, course, statusGif, changed))
                // d("infoinfo",description)
            }
        }
        return descriptions
    }
}