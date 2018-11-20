package nl.bartnijland.countrycodepickerdialog.utils

import nl.bartnijland.countrycodepickerdialog.models.CountryCode

object CountryCodesUtil {
    fun filterCountryCodes(country: String, countryCodes: List<CountryCode>): List<CountryCode> {
        return countryCodes.filter { it.name.toLowerCase().startsWith(country.toLowerCase()) }
    }
    fun getPositionForCountry(countryCode: String, countryCodes: List<CountryCode>): Int {
        val countryCode= countryCodes.firstOrNull { it.code.toLowerCase() == countryCode.toLowerCase() }
        return countryCodes.indexOf(countryCode)
    }
}