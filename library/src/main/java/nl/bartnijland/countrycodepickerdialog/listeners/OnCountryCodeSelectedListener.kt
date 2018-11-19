package nl.bartnijland.countrycodepickerdialog.listeners

import nl.bartnijland.countrycodepickerdialog.models.CountryCode

interface OnCountryCodeSelectedListener {
    fun onCountryCodeSelected(countryCode: CountryCode)
}