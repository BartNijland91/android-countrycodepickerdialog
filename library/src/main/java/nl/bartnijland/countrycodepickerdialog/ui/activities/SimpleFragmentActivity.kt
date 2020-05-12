package nl.bartnijland.countrycodepickerdialog.ui.activities

import android.os.Bundle
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.annotation.RestrictTo
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity

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