package org.nathit.currencybtc.common.ui.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

class AlertDialogUi(
    val title: String? = null,
    val message: String? = null,
    @StringRes val titleRes: Int? = null,
    @StringRes val messageRes: Int? = null,
    @DrawableRes val imageRes: Int? = null,
    @StringRes val positiveActionRes: Int? = null,
    @StringRes val negativeActionRes: Int? = null,
    val onPositiveClicked: () -> Unit = {},
    val onNegativeClicked: () -> Unit = {}
)