package org.nathit.currencybtc.convert

import org.nathit.currencybtc.common.ui.base.BaseViewModel
import java.text.DecimalFormat

class ConvertViewModel : BaseViewModel() {

    val displayHome: () -> Unit = {
        navigate(
            NavigationCommand.To(
                ConvertFragmentDirections.actionConvertFragmentToNavMain()
            )
        )
    }

}