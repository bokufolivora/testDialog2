package org.boku_folivora.testdialog2

import android.content.Context
import android.widget.BaseAdapter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.view.LayoutInflater


//
class ImageListAdapter(private val mContext: Context) : BaseAdapter() {
    private val mLayoutInflater: LayoutInflater = LayoutInflater.from(mContext)
    private val mImageList = ClsImageList()
    //
    private class ViewHolder {
        var iconImage : ImageView? = null
    }
    //
    override fun getCount(): Int {
        return mImageList.size
    }
    //
    override fun getView(position: Int, cView: View?, parent: ViewGroup): View {
        var convertView : View? = cView

        val holder: ViewHolder
        if (convertView == null) {
            holder = ViewHolder()
            convertView = mLayoutInflater.inflate(R.layout.cell, null)
            holder.iconImage =  convertView.findViewById(R.id.iconImage)
            convertView.tag = holder
        } else {
            holder = convertView.tag as ViewHolder
        }
        // イメージの設定
        holder.iconImage!!.setImageResource(mImageList.getDrawableID(position))

        return convertView!!
    }
    //
    override fun getItemId(position: Int): Long {
        return 0
    }
    //
    override fun getItem(position: Int): Any? {
        return null
    }
}