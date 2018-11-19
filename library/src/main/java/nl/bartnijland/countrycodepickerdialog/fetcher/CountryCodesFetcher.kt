package nl.bartnijland.countrycodepickerdialog.fetcher

import nl.bartnijland.countrycodepickerdialog.models.CountryCode
import org.json.JSONObject

class CountryCodesFetcher(private val jsonFetcher: CountryCodesJsonFetcher) {

    fun getCountryCodes(): List<CountryCode> {
        val countryCodes = mutableListOf<CountryCode>()
        val jsonArray = jsonFetcher.getJson()
        for (i in 0 until jsonArray.length()) {
            val jsonObject = jsonArray.getJSONObject(i)
            countryCodes.add(getCountryCodeFromJsonObject(jsonObject))
        }
        return countryCodes
    }

    private fun getCountryCodeFromJsonObject(jsonObject: JSONObject): CountryCode {
        return CountryCode(name = jsonObject.getString("name"),
                code = jsonObject.getString("code"),
                dialCode = jsonObject.getString("dial_code"))
    }
}