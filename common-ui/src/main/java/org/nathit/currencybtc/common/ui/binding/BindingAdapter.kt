package org.nathit.currencybtc.common.ui.binding

import android.widget.TextView
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter

@BindingAdapter(value = ["textString", "textRes"], requireAll = false)
fun bindTextStringAndRes(
    textView: TextView,
    text: String?,
    @StringRes textRes: Int?
) {
    text?.let {
        textView.text = it
    }
    textRes?.let {
        textView.setText(it)
    }
    textView.isVisible = text != null || textRes != null
}