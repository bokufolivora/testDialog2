package org.boku_folivora.testdialog2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.R.attr.fragment
import android.app.Activity
import android.content.Intent
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val requestCodeDialog : Int = 1001

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener { _ ->
            // 生成
            val dialog : ClsTextInputDialog = ClsTextInputDialog(this)
            // 表示
            dialog.openDialog( requestCodeDialog, supportFragmentManager)
        }
    }
    // コールバック
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if(requestCode == requestCodeDialog && resultCode == Activity.RESULT_OK) {
            val selNul : Int = data?.getIntExtra("parent",0) ?: 0
            Log.d("OK", selNul.toString())
            selectIcon.setImageResource(
                    ClsImageList().mImageList[selNul]
            )
        }
        else if(requestCode == requestCodeDialog && resultCode == Activity.RESULT_CANCELED) {
            Log.d("CANCELED", requestCode.toString())
        }
    }
}
