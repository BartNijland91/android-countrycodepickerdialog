package nl.bartnijland.countrycodepickerdialog.util

import android.graphics.drawable.BitmapDrawable
import android.view.View
import android.widget.ImageView
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

/**
 * A Matcher for Espresso that checks if an ImageView has a drawable applied to it.
 */
object ImageViewHasBitmapDrawableMatcher {

    fun hasDrawable(): BoundedMatcher<View, ImageView> {
        return object : BoundedMatcher<View, ImageView>(ImageView::class.java) {
            override fun describeTo(description: Description) {
                description.appendText("has drawable")
            }

            public override fun matchesSafely(imageView: ImageView): Boolean {
                return imageView.drawable is BitmapDrawable
                        && (imageView.drawable as BitmapDrawable).bitmap != null
            }
        }
    }
}
