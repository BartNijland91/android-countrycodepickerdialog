package nl.bartnijland.countrycodepickerdialog.ui.activities

import android.os.Bundle
import android.support.annotation.RestrictTo
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.view.ViewCompat
import android.view.ViewGroup
import android.widget.FrameLayout

@RestrictTo(RestrictTo.Scope.TESTS)
class SimpleFragmentActivity : FragmentActivity() {

    private val contentFrameId by lazy { ViewCompat.generateViewId() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val content = FrameLayout(this)
        content.layoutParams = FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT)
        content.id = contentFrameId
        setContentView(content)
    }

    fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
                .add(contentFrameId, fragment, "fragment")
                .commit()
    }
}