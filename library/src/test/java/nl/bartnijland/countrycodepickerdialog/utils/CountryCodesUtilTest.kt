package nl.bartnijland.countrycodepickerdialog.utils

import nl.bartnijland.countrycodepickerdialog.models.CountryCode
import org.junit.Assert.assertEquals
import org.junit.Test

class CountryCodesUtilTest {

    private val test1CountryCode = CountryCode(name = "test1", code = "test1", dialCode = "")
    private val test2CountryCode = CountryCode(name = "test2", code = "test2", dialCode = "")
    private val countryCodes = listOf(test1CountryCode, test2CountryCode)

    @Test
    fun testShouldNotFilter() {
        val filteredCountryCodes = CountryCodesUtil.filterCountryCodes("tes", countryCodes)
        assertEquals(filteredCountryCodes, countryCodes)
    }

    @Test
    fun testShouldFilterCountryCode() {
        val filteredCountryCodes = CountryCodesUtil.filterCountryCodes("test1", countryCodes)
        assertEquals(filteredCountryCodes, listOf(test1CountryCode))
    }

    @Test
    fun testShouldFilterAllCountryCode() {
        val filteredCountryCodes = CountryCodesUtil.filterCountryCodes("bla", countryCodes)
        assertEquals(filteredCountryCodes, listOf<CountryCode>())
    }

    @Test
    fun testShouldGetPositionForCountryCode() {
        val position = CountryCodesUtil.getPositionForCountry("test2", countryCodes)
        assertEquals(position, 1)
    }

    @Test
    fun testShouldNotGetPositionForCountryCode() {
        val position = CountryCodesUtil.getPositionForCountry("test3", countryCodes)
        assertEquals(position, -1)
    }

}