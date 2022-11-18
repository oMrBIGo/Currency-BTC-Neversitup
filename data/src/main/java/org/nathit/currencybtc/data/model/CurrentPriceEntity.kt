package org.nathit.currencybtc.data.model


import com.google.gson.annotations.SerializedName

data class CurrentPriceEntity(
    @SerializedName("bpi")
    val bpi: ArrayList<Bpi?>?,
    @SerializedName("chartName")
    val chartName: String?,
    @SerializedName("disclaimer")
    val disclaimer: String?,
    @SerializedName("time")
    val time: ArrayList<Time?>?
) {
    data class Bpi(
        @SerializedName("EUR")
        val eUR: ArrayList<EUR?>?,
        @SerializedName("GBP")
        val gBP: ArrayList<GBP?>?,
        @SerializedName("USD")
        val uSD: ArrayList<USD?>?
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