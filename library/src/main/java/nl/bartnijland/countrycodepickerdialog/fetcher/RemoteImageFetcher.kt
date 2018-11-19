package nl.bartnijland.countrycodepickerdialog.fetcher

import android.content.Context
import android.graphics.Bitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.request.target.SimpleTarget
import com.bumptech.glide.request.transition.Transition

class RemoteImageFetcher(val context: Context) : ImageFetcher {
    override fun loadImage(url: String, callback: (bitmap: Bitmap) -> Unit) {
        Glide
                .with(context)
                .asBitmap()
                .load(url)
                .into(object: SimpleTarget<Bitmap>() {
                    override fun onResourceReady(resource: Bitmap, transition: Transition<in Bitmap>?) {
                        callback.invoke(resource)
                    }
                })
    }
}