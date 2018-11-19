package nl.bartnijland.countrycodepickerdialog.fetcher

import android.graphics.Bitmap

interface ImageFetcher {
    fun loadImage(url: String, callback: (bitmap: Bitmap) -> Unit)
}