package com.example.submission5.utils

import android.view.View
import android.support.design.widget.Snackbar



fun View.visible(){
    visibility = View.VISIBLE
}

fun View.invisivle(){
    visibility = View.INVISIBLE
}

fun snackBar(msg: String, v: View) {
    Snackbar.make(v, msg, Snackbar.LENGTH_LONG).setAction("Action", null).show()
}