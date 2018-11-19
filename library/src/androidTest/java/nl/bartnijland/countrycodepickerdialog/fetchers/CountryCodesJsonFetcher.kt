package nl.bartnijland.countrycodepickerdialog.fetchers

import android.content.Context
import org.json.JSONArray
import org.json.JSONObject

class CountryCodesJsonFetcher(private val context: Context) {
    fun getJson(): JSONArray {
        val country1 = JSONObject()
        country1.put("name", "Israel")
        country1.put("dial_code", "+972")
        country1.put("code", "IL")

        val country2 = JSONObject()
        country2.put("name", "Afghanistan")
        country2.put("dial_code", "+93")
        country2.put("code", "AF")

        val jsonArray = JSONArray()
        jsonArray.put(country1)
        jsonArray.put(country2)
        return jsonArray
    }
}