package com.example.internetconnectionexample

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.os.AsyncTask
import java.io.BufferedInputStream
import java.io.InputStream
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class ImageUtils (val resolveBitmap: (Bitmap) -> Unit): AsyncTask<String, Void, Bitmap>() {
    override fun doInBackground(vararg params: String?): Bitmap? {
        var mBitmap: Bitmap? = null
        val url = URL(params[0])
        try {
            val urlConnection: HttpURLConnection = url.openConnection() as HttpURLConnection
            urlConnection.doInput = true
            urlConnection.connect()
            val inputStream: InputStream = BufferedInputStream(urlConnection.inputStream)
            mBitmap = BitmapFactory.decodeStream(inputStream)
        } catch (e: Exception) {
            // do something
        }
        return if (mBitmap != null) mBitmap else null
    }

    override fun onPostExecute(result: Bitmap?) {
        super.onPostExecute(result)
        result?.let { resolveBitmap(it) }
    }
}
