package org.boku_folivora.testdialog2

// サンプルデータ
class ClsImageList {
    val mImageList :Array<Int> = arrayOf<Int>(
            R.drawable.ic_1001 ,
            R.drawable.ic_1002 ,
            R.drawable.ic_1003 ,
            R.drawable.ic_1004 ,
            R.drawable.ic_1005 ,
            R.drawable.ic_1006 ,
            R.drawable.ic_1007 ,
            R.drawable.ic_1008 ,
            R.drawable.ic_1009 ,
            R.drawable.ic_1010 ,
            R.drawable.ic_1011 ,
            R.drawable.ic_1012 ,
            R.drawable.ic_1013 ,
            R.drawable.ic_1014 ,
            R.drawable.ic_1015 ,
            R.drawable.ic_1016 ,
            R.drawable.ic_1017 ,
            R.drawable.ic_1018 ,
            R.drawable.ic_1019
    )

    val size : Int
        get() {
            return mImageList.size
        }

    fun getDrawableID( position: Int) : Int {
        return if (mImageList.size > position ) {
            mImageList[position]
        } else {
            0
        }
    }
}