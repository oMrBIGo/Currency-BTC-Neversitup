package org.nathit.currencybtc.data.model


import com.google.gson.annotations.SerializedName

data class CurrentPriceEntity(
    @SerializedName("time")
    val time: Time,
    @SerializedName("chartName")
    val chartName: String?,
    @SerializedName("disclaimer")
    val disclaimer: String?,
    @SerializedName("bpi")
    val bpi: Bpi
) {
    data class Bpi(
        @SerializedName("EUR")
        val eUR: EUR,
        @SerializedName("GBP")
        val gBP: GBP,
        @SerializedName("USD")
        val uSD: USD
    ) {
        data class EUR(
            @SerializedName("code")
            val code: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("rate")
            val rate: String?,
            @SerializedName("rate_float")
            val rateFloat: Double?,
            @SerializedName("symbol")
            val symbol: String?
        )

        data class GBP(
            @SerializedName("code")
            val code: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("rate")
            val rate: String?,
            @SerializedName("rate_float")
            val rateFloat: Double?,
            @SerializedName("symbol")
            val symbol: String?
        )

        data class USD(
            @SerializedName("code")
            val code: String?,
            @SerializedName("description")
            val description: String?,
            @SerializedName("rate")
            val rate: String?,
            @SerializedName("rate_float")
            val rateFloat: Double?,
            @SerializedName("symbol")
            val symbol: String?
        )
    }

    data class Time(
        @SerializedName("updated")
        val updated: String?,
        @SerializedName("updatedISO")
        val updatedISO: String?,
        @SerializedName("updateduk")
        val updateduk: String?
    )
}