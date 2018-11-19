package nl.bartnijland.countrycodepickerdialog.util

import android.graphics.Bitmap
import nl.bartnijland.countrycodepickerdialog.fetcher.ImageFetcher

class DummyImageFetcher : ImageFetcher {
    override fun loadImage(url: String, callback: (bitmap: Bitmap) -> Unit) {
        val bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888 )
        callback.invoke(bitmap)
    }
}