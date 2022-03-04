package fr.com.tn.majdi.livenews.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by Majdi RABEH on 29/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
@Parcelize
data class SourcePresentation(
    val id: String,
    val name: String
): Parcelable