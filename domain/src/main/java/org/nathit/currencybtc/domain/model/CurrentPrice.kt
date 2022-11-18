package org.nathit.currencybtc.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentPrice(
    val bpi: Bpi,
    val chartName: String = "",
    val disclaimer: String = "",
    val time: Time
) : Parcelable {
    @Parcelize
    data class Bpi(
        val eUR: EUR,
        val gBP: GBP,
        val uSD: USD
    ) : Parcelable {
        @Parcelize
        data class EUR(
            val code: String = "",
            val description: String = "",
            val rate: String = "",
            val rateFloat: Double = 0.0,
            val symbol: String = ""
        ) : Parcelable
        @Parcelize
        data class GBP(
            val code: String = "",
            val description: String = "",
            val rate: String = "",
            val rateFloat: Double = 0.0,
            val symbol: String = ""
        ) : Parcelable
        @Parcelize
        data class USD(
            val code: String = "",
            val description: String = "",
            val rate: String = "",
            val rateFloat: Double = 0.0,
            val symbol: String = ""
        ) : Parcelable
    }
    @Parcelize
    data class Time(
        val updated: String = "",
        val updatedISO: String = "",
        val updateduk: String = ""
    ) : Parcelable
}