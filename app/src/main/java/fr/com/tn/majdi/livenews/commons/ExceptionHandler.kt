package fr.com.tn.majdi.livenews.commons

import androidx.annotation.StringRes
import fr.com.tn.majdi.livenews.R
import java.net.UnknownHostException

/**
 * Created by Majdi RABEH on 29/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
internal object ExceptionHandler {

    @StringRes
    fun parse(t: Throwable): Int {
        return when (t) {
            is UnknownHostException -> R.string.error_check_internet_connection
            else -> R.string.error_oops_error_occured
        }
    }

}