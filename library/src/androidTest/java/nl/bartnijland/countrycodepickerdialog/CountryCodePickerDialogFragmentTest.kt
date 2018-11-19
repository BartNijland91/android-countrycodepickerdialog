package nl.bartnijland.countrycodepickerdialog

import android.content.Intent
import android.os.Bundle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.rule.ActivityTestRule
import nl.bartnijland.countrycodepickerdialog.ui.activities.SimpleFragmentActivity
import nl.bartnijland.countrycodepickerdialog.ui.fragments.CountryCodePickerDialogFragment
import nl.bartnijland.countrycodepickerdialog.util.CountryCodesJsonFromMemoryFetcher
import nl.bartnijland.countrycodepickerdialog.util.DummyImageFetcher
import nl.bartnijland.countrycodepickerdialog.util.ImageViewHasBitmapDrawableMatcher
import nl.bartnijland.countrycodepickerdialog.util.RecyclerViewItemCountAssertion.Companion.withItemCount
import nl.bartnijland.countrycodepickerdialog.util.RecyclerViewMatcher
import org.hamcrest.Matchers.not
import org.junit.Assert.assertNull
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CountryCodePickerDialogFragmentTest {

    @get:Rule
    val activityRule: ActivityTestRule<SimpleFragmentActivity> = ActivityTestRule(SimpleFragmentActivity::class.java, true , false)

    private val fragment = CountryCodePickerDialogFragment()

    private fun withRecyclerView(recyclerViewId: Int): RecyclerViewMatcher {
        return RecyclerViewMatcher(recyclerViewId)
    }

    @Before
    fun setUp() {
        fragment.jsonFetcher = CountryCodesJsonFromMemoryFetcher()
        fragment.imageFetcher = DummyImageFetcher()
    }

    private fun launchActivity(defaultSelectedCountry: String? = null) {
        defaultSelectedCountry?.let {
            val bundle = Bundle()
            bundle.putString("EXTRA_DEFAULT_COUNTRY", defaultSelectedCountry)
            fragment.arguments = bundle
        }
        activityRule.launchActivity(Intent())
        activityRule.activity.setFragment(fragment)
    }

    @Test
    fun testShouldDisplayCountries() {
        launchActivity()

        onView(withId(R.id.viewDialogCountryCodePickerEmpty)).check(matches(not(isDisplayed())))
        onView(withId(R.id.viewDialogCountryCodePickerRv)).check(withItemCount(20))

        onView(withRecyclerView(R.id.viewDialogCountryCodePickerRv).atPositionOnView(0, R.id.viewCountryCodePickerRowCountry))
                .check(matches(withText("Afghanistan")))

        onView(withRecyclerView(R.id.viewDialogCountryCodePickerRv).atPositionOnView(0, R.id.viewCountryCodePickerRowDialCode))
                .check(matches(withText("+93")))

        onView(withRecyclerView(R.id.viewDialogCountryCodePickerRv).atPositionOnView(0, R.id.viewCountryCodePickerRowFlag))
                .check(matches(ImageViewHasBitmapDrawableMatcher.hasDrawable()))
    }

    @Test
    fun testShouldFilterCountries() {
        launchActivity()
        onView(withId(R.id.viewDialogCountryCodePickerSearch)).perform(ViewActions.typeText("Afghanistan"))
        onView(withId(R.id.viewDialogCountryCodePickerRv)).check(withItemCount(1))
    }

    @Test
    fun testShouldPresentEmptyState() {
        launchActivity()
        onView(withId(R.id.viewDialogCountryCodePickerSearch)).perform(ViewActions.typeText("12034982094uweofl"))
        onView(withId(R.id.viewDialogCountryCodePickerEmpty)).check(matches(isDisplayed()))
    }

    @Test
    fun testShouldScrollToDefaultSelectCountry() {
        launchActivity("be")
        onView(withRecyclerView(R.id.viewDialogCountryCodePickerRv).atPositionOnView(19, R.id.viewCountryCodePickerRowCountry))
                .check(matches(withText("Belgium")))
    }

    @Test
    fun testShouldNotScrollToDefaultSelectCountry() {
        launchActivity()
        onView(withRecyclerView(R.id.viewDialogCountryCodePickerRv).atPositionOnView(0, R.id.viewCountryCodePickerRowCountry))
                .check(matches(withText("Afghanistan")))
    }

    @Test
    fun testShouldRemoveFragment() {
        launchActivity()
        onView(withRecyclerView(R.id.viewDialogCountryCodePickerRv).atPositionOnView(0, R.id.viewCountryCodePickerRowCountry)).perform(click())

        val fragment = activityRule.activity.supportFragmentManager.findFragmentByTag("fragment")
        assertNull(fragment)
    }
}