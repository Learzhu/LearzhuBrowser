package com.learzhu.browser.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.learzhu.browser.R

class RecyclerViewActivity1 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
    }

    //在 Kotlin 中没有 static 类型的 fun，但是我们可以使用 Companion Objects 。
//    companion object Factory {
//        fun create(): RecyclerViewActivity = RecyclerViewActivity()
//    }
    //companion object 的名字可以省略
//    companion object {
//        @JvmStatic
//        fun actionStart(context: Context) {
//            var intent = Intent()
//            intent.setClass(context, RecyclerViewActivity1::class.java)
//            context.startActivity(intent)
//        }
//    }

}
