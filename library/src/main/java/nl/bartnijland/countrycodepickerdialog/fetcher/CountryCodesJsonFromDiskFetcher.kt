package nl.bartnijland.countrycodepickerdialog.fetcher

import android.content.Context
import org.json.JSONArray

class CountryCodesJsonFromDiskFetcher(private val context: Context) : CountryCodesJsonFetcher {
    override fun getJson(): JSONArray {
        val jsonString = context.assets.open("country_codes.json").bufferedReader().use {
            it.readText()
        }
        return JSONArray(jsonString)
    }
}