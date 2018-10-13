package org.boku_folivora.testdialog2

import android.app.Activity
import android.content.Context
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AlertDialog
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.GridView
import android.content.Intent
import android.app.PendingIntent

//
class ClsTextInputDialog( mc:Context) {
    private val mDialog : MyDialog = MyDialog()

    init {
        mDialog.mContext = mc
    }
    // ダイアログ表示
    fun openDialog(requestCode:Int, manager: FragmentManager) {
        mDialog.setTargetFragment(null,requestCode)
        mDialog.show( manager,"dialog")
    }
    // イメージ選択のダイアログ
    class MyDialog : DialogFragment() {
        var mContext : Context? =null
        //
        override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
            val alertView : View = activity!!.layoutInflater.inflate(R.layout.view_dialog, null)
            // イメージクリック　
            val mIconGridView =alertView.findViewById(R.id.iconGridView2) as GridView
            mIconGridView.adapter = ImageListAdapter(mContext!!)
            mIconGridView.setOnItemClickListener { _, _, position, _ ->
                val result = Intent()
                result.putExtra("parent",position )
                val pi = activity!!.createPendingResult(targetRequestCode, result, PendingIntent.FLAG_ONE_SHOT)
                try {
                    pi.send(Activity.RESULT_OK)
                } catch (ex: PendingIntent.CanceledException) {
                    ex.printStackTrace()
                }
                dialog.dismiss()
            }
            // キャンセルボタン
            val mCancelButton = alertView.findViewById(R.id.button_cancel) as Button
            mCancelButton.setOnClickListener {
                val pi = activity!!.createPendingResult(targetRequestCode, Intent(), PendingIntent.FLAG_ONE_SHOT)
                try {
                    pi.send(Activity.RESULT_CANCELED)
                } catch (ex: PendingIntent.CanceledException) {
                    ex.printStackTrace()
                }
            }

            // 実際は AlertDialog を使用
            val dialogBuilder = AlertDialog.Builder(activity!!)
            dialogBuilder.setView(alertView)
            return dialogBuilder.create()
        }
        override fun onPause() {
            super.onPause()
            dismiss()
        }
    }
}