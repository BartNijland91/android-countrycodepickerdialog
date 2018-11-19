package nl.bartnijland.countrycodepickerdialog.util

import nl.bartnijland.countrycodepickerdialog.fetcher.CountryCodesJsonFetcher
import org.json.JSONArray
import org.json.JSONObject

class CountryCodesJsonFromMemoryFetcher: CountryCodesJsonFetcher {
    override fun getJson(): JSONArray {
        val jsonArray = JSONArray()
        jsonArray.put(getCountryJsonObject("Afghanistan", "+93", "AF"))
        jsonArray.put(getCountryJsonObject("Albania", "+355", "AL"))
        jsonArray.put(getCountryJsonObject("Algeria", "+213", "DZ"))
        jsonArray.put(getCountryJsonObject("AmericanSamoa", "+1 684", "AS"))
        jsonArray.put(getCountryJsonObject("Andorra", "+376", "AD"))
        jsonArray.put(getCountryJsonObject("Angola", "+244", "AO"))
        jsonArray.put(getCountryJsonObject("Anguilla", "+1 264", "AI"))
        jsonArray.put(getCountryJsonObject("Antigua and Barbuda", "+1268", "AG"))
        jsonArray.put(getCountryJsonObject("Argentina", "+54", "AR"))
        jsonArray.put(getCountryJsonObject("Armenia", "+374", "AM"))
        jsonArray.put(getCountryJsonObject("Aruba", "+297", "AW"))
        jsonArray.put(getCountryJsonObject("Australia", "+61", "AU"))
        jsonArray.put(getCountryJsonObject("Austria", "+43", "AT"))
        jsonArray.put(getCountryJsonObject("Azerbaijan", "+994", "AZ"))
        jsonArray.put(getCountryJsonObject("Bahamas", "+1 242", "BS"))
        jsonArray.put(getCountryJsonObject("Bahrain", "+973", "BH"))
        jsonArray.put(getCountryJsonObject("Bangladesh", "+880", "BD"))
        jsonArray.put(getCountryJsonObject("Barbados", "+1 246", "BB"))
        jsonArray.put(getCountryJsonObject("Belarus", "+375", "BY"))
        jsonArray.put(getCountryJsonObject("Belgium", "+32", "BE"))
        return jsonArray
    }

    private fun getCountryJsonObject(countryName: String, dialCode: String, code: String? = ""): JSONObject {
        val country = JSONObject()
        country.put("name", countryName)
        country.put("dial_code", dialCode)
        country.put("code", code)
        return country
    }
}