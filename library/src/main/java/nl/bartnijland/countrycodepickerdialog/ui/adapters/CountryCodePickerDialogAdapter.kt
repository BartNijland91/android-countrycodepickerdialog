package nl.bartnijland.countrycodepickerdialog.ui.adapters

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import nl.bartnijland.countrycodepickerdialog.R
import nl.bartnijland.countrycodepickerdialog.fetcher.ImageFetcher
import nl.bartnijland.countrycodepickerdialog.listeners.OnCountryCodeSelectedListener
import nl.bartnijland.countrycodepickerdialog.models.CountryCode
import nl.bartnijland.countrycodepickerdialog.utils.CountryCodesUtil

class CountryCodePickerDialogAdapter(
        private val onCountryCodeSelectedListener: OnCountryCodeSelectedListener?,
        private val imageFetcher: ImageFetcher) : RecyclerView.Adapter<CountryCodePickerDialogAdapter.CountryCodeRowViewHolder>() {

    val countryCodes = mutableListOf<CountryCode>()
    private val filteredCountryCodes = mutableListOf<CountryCode>()

    init {
        filteredCountryCodes.addAll(countryCodes)
    }

    fun setCountryCodes(countryCodes: List<CountryCode>) {
        this.countryCodes.addAll(countryCodes)
        filteredCountryCodes.addAll(countryCodes)
        notifyDataSetChanged()
    }

    fun filterCountryCodes(country: String): List<CountryCode> {
        val newFilteredCountryCodes = CountryCodesUtil.filterCountryCodes(country, countryCodes)
        filteredCountryCodes.clear()
        filteredCountryCodes.addAll(newFilteredCountryCodes)
        notifyDataSetChanged()
        return newFilteredCountryCodes
    }

    inner class CountryCodeRowViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val flag = itemView.findViewById<ImageView>(R.id.viewCountryCodePickerRowFlag)!!
        val country = itemView.findViewById<TextView>(R.id.viewCountryCodePickerRowCountry)!!
        val dialCode = itemView.findViewById<TextView>(R.id.viewCountryCodePickerRowDialCode)!!
    }

    override fun onCreateViewHolder(parent: ViewGroup, position: Int): CountryCodeRowViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dialog_country_code_picker_row, parent, false)
        return CountryCodeRowViewHolder(view)
    }

    override fun onBindViewHolder(viewHolder: CountryCodeRowViewHolder, position: Int) {
        val countryCode = filteredCountryCodes[position]

        viewHolder.flag.setImageBitmap(null)

        imageFetcher.loadImage(url = "https://www.countryflags.io/${countryCode.code.toLowerCase()}/flat/64.png", callback = {
            viewHolder.flag.setImageBitmap(it)
        })

        viewHolder.country.text = countryCode.name
        viewHolder.dialCode.text = countryCode.dialCode

        viewHolder.itemView.setOnClickListener {
            onCountryCodeSelectedListener?.onCountryCodeSelected(countryCode)
        }
    }

    override fun getItemCount(): Int {
        return filteredCountryCodes.size
    }

}