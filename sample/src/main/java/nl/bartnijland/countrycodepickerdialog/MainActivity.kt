package nl.bartnijland.countrycodepickerdialog

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import nl.bartnijland.countrycodepickerdialog.listeners.OnCountryCodeSelectedListener
import nl.bartnijland.countrycodepickerdialog.models.CountryCode
import nl.bartnijland.countrycodepickerdialog.ui.fragments.CountryCodePickerDialogFragment

class MainActivity : AppCompatActivity(), OnCountryCodeSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewButton.setOnClickListener {
            CountryCodePickerDialogFragment.getInstance().show(supportFragmentManager, null)
        }
    }

    override fun onCountryCodeSelected(countryCode: CountryCode) {
        viewCountryCode.text = countryCode.toString()
    }

}
