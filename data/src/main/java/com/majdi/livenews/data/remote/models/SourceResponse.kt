package com.majdi.livenews.data.remote.models

import com.squareup.moshi.Json
/**
 * Created by Majdi RABEH on 28/02/2022.
 * Email m.rabeh.majdi@gmail.com
 */
data class SourceResponse(
    @field:Json(name = "id") val id: String,
    @field:Json(name = "name") val name: String
)