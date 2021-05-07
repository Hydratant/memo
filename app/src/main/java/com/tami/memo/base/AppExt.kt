package com.tami.memo.base

import android.app.Application
import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageManager
import android.view.View
import android.view.ViewTreeObserver
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.getSystemService


fun Context.isDebug(): Boolean {
    val isDebug: Boolean
    try {
        val appInfo = packageManager.getApplicationInfo(packageName, 0)
        isDebug = (0 != (appInfo.flags and ApplicationInfo.FLAG_DEBUGGABLE))
    } catch (ne: PackageManager.NameNotFoundException) {
        return false
    }
    return isDebug
}

fun Application.getLabel(): String {
    return applicationInfo.loadLabel(packageManager).toString()
}

fun View.showKeyboard() {
    viewTreeObserver.addOnGlobalLayoutListener(object : ViewTreeObserver.OnGlobalLayoutListener {
        override fun onGlobalLayout() {
            requestFocus()
            context.getSystemService<InputMethodManager>()
                ?.showSoftInput(this@showKeyboard, InputMethodManager.SHOW_IMPLICIT)
            viewTreeObserver.removeOnGlobalLayoutListener(this)
        }
    })
}

fun AppCompatActivity.getText(text: Any?): CharSequence? {
    if (text == null) return null
    if (text is CharSequence) return text
    return if (text is Int) getString((text as Int?)!!) else text.toString()
}


