package com.example.internetconnectionexample

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonDownload.setOnClickListener { downloadImage() }
    }

    private fun downloadImage() {
        val url = "https://xagian.net/wp-content/uploads/2019/03/55790088_644474739321582_7421982402664202240_n.jpg"
        ImageUtils(::setImageBitmap).execute(url)
    }

    private fun setImageBitmap(bitmap: Bitmap) {
        imageDownload.setImageBitmap(bitmap)
    }
}
