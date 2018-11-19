package nl.bartnijland.countrycodepickerdialog

import androidx.test.ext.junit.runners.AndroidJUnit4
import nl.bartnijland.countrycodepickerdialog.fetcher.CountryCodesFetcher
import nl.bartnijland.countrycodepickerdialog.models.CountryCode
import nl.bartnijland.countrycodepickerdialog.util.CountryCodesJsonFromMemoryFetcher
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountryCodesFetcherTest {

    private lateinit var fetcher: CountryCodesFetcher

    @Before
    fun init() {
        fetcher = CountryCodesFetcher(CountryCodesJsonFromMemoryFetcher())
    }

    @Test
    fun testShouldReturnListOfCountryCodes() {
        val expectedCountry1 = CountryCode(name = "Afghanistan",
                dialCode = "+93",
                code = "AF")
        assertEquals(fetcher.getCountryCodes()[0], expectedCountry1)
    }


}