package org.nathit.currencybtc.common.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class ToolbarUi(
    @StringRes val titleRes: Int? = null,
    val title: String? = null,
    @DrawableRes val navigationIconRes: Int? = null
)