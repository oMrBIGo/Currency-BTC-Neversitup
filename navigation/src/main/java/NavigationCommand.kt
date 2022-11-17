import androidx.annotation.IdRes
import androidx.navigation.NavDirections

/**
 * A simple sealed class to handle more properly
 * navigation from a [ViewModel]
 */
sealed class NavigationCommand {
    data class To(val directions: NavDirections) : NavigationCommand()
    data class BackTo(@IdRes val destinationId: Int, val inclusive: Boolean) : NavigationCommand()
    object Back : NavigationCommand()
}
