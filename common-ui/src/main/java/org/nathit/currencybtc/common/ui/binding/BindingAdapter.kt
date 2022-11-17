package org.nathit.currencybtc.common.ui.binding

import android.os.Build
import android.util.TypedValue
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.core.content.ContextCompat
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.databinding.BindingAdapter
import coil.ImageLoader
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.google.android.material.appbar.AppBarLayout
import com.google.android.material.appbar.MaterialToolbar
import org.nathit.currencybtc.common.R

@BindingAdapter("isVisible")
fun bindIsVisible(view: View, isVisible: Boolean) {
    view.isVisible = isVisible
}

@BindingAdapter("isInVisible")
fun bindInIsVisible(view: View, isInVisible: Boolean) {
    view.isInvisible = isInVisible
}

@BindingAdapter("imageUrl")
fun bindImage(imageView: ImageView, imageUrl: String?) {
    val request = ImageRequest.Builder(imageView.context).apply {
        data(imageUrl)
        target(imageView)
    }.build()

    val loader = ImageLoader.Builder(imageView.context).apply {
        componentRegistry {
            if (Build.VERSION.SDK_INT >= 28) add(ImageDecoderDecoder()) else add(GifDecoder())
        }
    }.build()
    loader.enqueue(request)
    imageView.tag = imageUrl
}

@BindingAdapter("showIfLoading")
fun bindLoading(view: View, isLoading: Boolean) {
    view.isVisible = isLoading
}

@BindingAdapter(value = ["navigationIconRes", "isHaveRightMenu"], requireAll = false)
fun bindNavigationIcon(
    view: MaterialToolbar,
    @DrawableRes drawable: Int,
    isHaveRightMenu: Boolean? = false
) {
    view.navigationIcon = ContextCompat.getDrawable(view.context, drawable)
    view.navigationIcon?.setTint(ContextCompat.getColor(view.context, R.color.white))
    if (isHaveRightMenu == false) {
        val params = view.layoutParams as AppBarLayout.LayoutParams
        val tv = TypedValue()
        var actionBarHeight = 0
        if (view.context.theme.resolveAttribute(android.R.attr.actionBarSize, tv, true)) {
            actionBarHeight =
                TypedValue.complexToDimensionPixelSize(tv.data, view.resources.displayMetrics)
        }
        params.setMargins(0, 0, actionBarHeight, 0)
        view.layoutParams = params
    }
    view.setPadding(0, 0, 0, 0)
}

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

@BindingAdapter(value = ["textNumberInt", "textNumberDouble"], requireAll = false)
fun bindTextNumber(
    textView: TextView,
    textInt: Int?,
    textDouble: Int?
) {
    textInt?.let {
        textView.text = String.format("%,2d", textInt)
    }
    textDouble?.let {
        textView.text = String.format("%,.2f", textDouble)
    }
    textView.isVisible = textInt != null || textDouble != null
}
