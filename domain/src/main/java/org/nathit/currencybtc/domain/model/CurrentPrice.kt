package org.nathit.currencybtc.domain.model

data class CurrentPrice(
    val bpi: Bpi,
    val chartName: String = "",
    val disclaimer: String = "",
    val time: Time
) {
    data class Bpi(
        val eUR: EUR,
        val gBP: GBP,
        val uSD: USD
    ) {
        data class EUR(
            val code: String = "",
            val description: String = "",
            val rate: String = "",
            val rateFloat: Double = 0.0,
            val symbol: String = ""
        )

        data class GBP(
            val code: String = "",
            val description: String = "",
            val rate: String = "",
            val rateFloat: Double = 0.0,
            val symbol: String = ""
        )

        data class USD(
            val code: String = "",
            val description: String = "",
            val rate: String = "",
            val rateFloat: Double = 0.0,
            val symbol: String = ""
        )
    }

    data class Time(
        val updated: String = "",
        val updatedISO: String = "",
        val updateduk: String = ""
    )
}