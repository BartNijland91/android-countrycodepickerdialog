package nl.bartnijland.countrycodepickerdialog

import android.content.Context
import nl.bartnijland.countrycodepickerdialog.fetcher.CountryCodesJsonFetcher
import nl.bartnijland.countrycodepickerdialog.fetcher.CountryCodesJsonFromDiskFetcher

object CountryCodePickerDataManager {
    fun getJsonFetcher(context: Context): CountryCodesJsonFetcher = CountryCodesJsonFromDiskFetcher(context)
}