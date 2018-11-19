package nl.bartnijland.countrycodepickerdialog.fetcher

import org.json.JSONArray

interface CountryCodesJsonFetcher {
    fun getJson(): JSONArray
}