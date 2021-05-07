package com.tami.memo.base

import android.content.Context
import android.content.DialogInterface
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import timber.log.Timber

abstract class BaseActivity : AppCompatActivity() {
    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        onLoadOnce()
    }

    abstract fun onLoadOnce()

    open fun showDialog(
        message: Any?,
        positiveButtonText: Any?,
        positiveListener: DialogInterface.OnClickListener? = null,
        negativeButtonText: Any? = null,
        negativeListener: DialogInterface.OnClickListener? = null
    ): AlertDialog {
        val dlg = getDialog(
            this,
            message,
            positiveButtonText,
            positiveListener,
            negativeButtonText,
            negativeListener
        ).apply {
            setCanceledOnTouchOutside(false)
            setCancelable(false)
        }
        if (lifecycle.currentState == Lifecycle.State.DESTROYED) {
            Timber.w("activity is Lifecycle destroyed")
            return dlg
        }
        if (isFinishing) {
            Timber.w("activity is isFinishing")
            return dlg
        }
        dlg.show()
        return dlg
    }

    open fun getDialog(
        context: Context,
        message: Any?,
        positiveButtonText: Any?,
        positiveListener: DialogInterface.OnClickListener? = null,
        negativeButtonText: Any? = null,
        negativeListener: DialogInterface.OnClickListener? = null
    ): AlertDialog {
        val builder = AlertDialog.Builder(context)
        if (message != null) builder.setMessage(getText(message))
        if (positiveButtonText != null) builder.setPositiveButton(
            getText(positiveButtonText),
            positiveListener
        )
        if (negativeButtonText != null) builder.setNegativeButton(
            getText(negativeButtonText),
            negativeListener
        )
        return builder.create()
    }
}