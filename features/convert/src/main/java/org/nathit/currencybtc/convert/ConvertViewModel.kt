package org.nathit.currencybtc.convert

import NavigationCommand
import org.nathit.currencybtc.common.ui.base.BaseViewModel

class ConvertViewModel : BaseViewModel() {

    val displayHome: () -> Unit = {
        navigate(
            NavigationCommand.To(
                ConvertFragmentDirections.actionConvertFragmentToNavMain()
            )
        )
    }

}