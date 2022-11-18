package org.nathit.currencybtc.common.ui.base

import NavigationCommand
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.ViewModel
import org.koin.java.KoinJavaComponent
import org.nathit.currencybtc.common.R
import org.nathit.currencybtc.common.ui.model.AlertDialogUi
import org.nathit.currencybtc.common.ui.model.ToolbarUi
import org.nathit.currencybtc.common.ui.util.SingleLiveEvent
import org.nathit.currencybtc.domain.model.CommonError
import org.nathit.currencybtc.domain.usecase.SecurePreferencesUseCase

abstract class BaseViewModel() : ViewModel() {
    val progressDialogEvent by lazy { SingleLiveEvent<Boolean>() }
    val alertDialogEvent by lazy { SingleLiveEvent<AlertDialogUi>() }
    val navigateEvent by lazy { SingleLiveEvent<NavigationCommand>() }
    val toolbar by lazy { SingleLiveEvent<ToolbarUi>() }

    fun initToolbar(
        @StringRes titleRes: Int? = null,
        title: String? = null,
        @DrawableRes navigationIconRes: Int? = R.drawable.ic_back
    ) {
        toolbar.value =
            ToolbarUi(titleRes = titleRes, title = title, navigationIconRes = navigationIconRes)
    }

    fun createOneButtonDialogEvent(
        title: String? = null,
        message: String? = null,
        @StringRes titleRes: Int? = null,
        @StringRes messageRes: Int? = null,
        @StringRes positiveActionRes: Int = R.string.ok,
        onPositiveClicked: () -> Unit = {}
    ) {
        alertDialogEvent.value = AlertDialogUi(
            title = title,
            message = message,
            titleRes = titleRes,
            messageRes = messageRes,
            positiveActionRes = positiveActionRes,
            onPositiveClicked = onPositiveClicked
        )
    }

    fun createAlertDialogEvent(
        message: String? = null,
        @StringRes messageRes: Int? = null
    ) {
        createOneButtonDialogEvent(
            message = message,
            titleRes = R.string.Error_Default_title,
            messageRes = messageRes
        )
    }

    fun navigate(navigationCommand: NavigationCommand) {
        navigateEvent.value = navigationCommand
    }

    /** Set isHost = true on SplashScreenViewModel only for navigate to login page **/
    fun handlerError(
        error: CommonError,
        onPositiveClicked: () -> Unit = {}
    ) {
        createOneButtonDialogEvent(
            message = error.message,
            onPositiveClicked = onPositiveClicked
        )
    }
}