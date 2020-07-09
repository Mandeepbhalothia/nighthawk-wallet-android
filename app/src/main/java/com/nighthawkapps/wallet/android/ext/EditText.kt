package com.nighthawkapps.wallet.android.ext

import android.view.inputmethod.EditorInfo.IME_ACTION_DONE
import android.widget.EditText
import android.widget.TextView
import cash.z.ecc.android.sdk.ext.convertZecToZatoshi
import cash.z.ecc.android.sdk.ext.safelyConvertToBigDecimal

fun EditText.onEditorActionDone(block: (EditText) -> Unit) {
    this.setOnEditorActionListener { _, actionId, _ ->
        if (actionId == IME_ACTION_DONE) {
            block(this)
            true
        } else {
            false
        }
    }
}

fun TextView.convertZecToZatoshi(): Long? {
    return try {
        text.toString().replace(',', '.').safelyConvertToBigDecimal()?.convertZecToZatoshi() ?: null
    } catch (t: Throwable) {
        null
    }
}
