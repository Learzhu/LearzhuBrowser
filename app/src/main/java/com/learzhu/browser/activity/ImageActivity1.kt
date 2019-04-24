package com.learzhu.browser.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learzhu.browser.R

class ImageActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)
//        showDialog()
    }

//    private fun showDialog() {
//        val myView: View = LayoutInflater.from(this).inflate(R.layout.notification_template_big_media_custom, null)
//        MaterialDialog(this).show {
//            customView(view = myView, scrollable = true)
//        }
//    }
}
