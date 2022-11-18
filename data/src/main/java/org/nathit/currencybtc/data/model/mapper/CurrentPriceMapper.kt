package org.nathit.currencybtc.data.model.mapper

import org.nathit.currencybtc.data.model.CurrentPriceEntity
import org.nathit.currencybtc.domain.model.CurrentPrice

class CurrentPriceMapper : Mapper<CurrentPriceEntity, CurrentPrice>{

    override fun map(input: CurrentPriceEntity): CurrentPrice {
        return with(input) {
            CurrentPrice(
                time = getTime(this.time ?: ArrayList()),
                disclaimer = this.disclaimer ?: "",
                chartName = this.chartName ?: "",
                bpi = getBpi(this.bpi ?: ArrayList())
            )
        }
    }

    private fun getTime(results: ArrayList<CurrentPriceEntity.Time?>) : ArrayList<CurrentPrice.Time> {
        val time = ArrayList<CurrentPrice.Time>()
        results.map { data ->
            time.add(
                CurrentPrice.Time(
                    updated = data?.updated ?: "",
                    updateduk = data?.updateduk ?: "",
                    updatedISO = data?.updatedISO ?: ""
                )
            )
        }
        return time
    }

    private fun getBpi(results: ArrayList<CurrentPriceEntity.Bpi?>) : ArrayList<CurrentPrice.Bpi> {
        val bpi = ArrayList<CurrentPrice.Bpi>()
        results.map { data ->
            bpi.add(
                CurrentPrice.Bpi(
                    uSD = getPriceUSD(data?.uSD ?: ArrayList()),
                    gBP = getPriceGBP(data?.gBP ?: ArrayList()),
                    eUR = getPriceEUR(data?.eUR ?: ArrayList())
                )
            )
        }
        return bpi
    }

    private fun getPriceUSD(results: ArrayList<CurrentPriceEntity.Bpi.USD?>) : ArrayList<CurrentPrice.Bpi.USD> {
        val priceUSD = ArrayList<CurrentPrice.Bpi.USD>()
        results.map { data ->
            priceUSD.add(
                CurrentPrice.Bpi.USD(
                    code = data?.code ?: "",
                    symbol = data?.symbol ?: "",
                    rate = data?.rate ?: "",
                    description = data?.description ?: "",
                    rateFloat = data?.rateFloat ?: 0.0
                )
            )
        }
        return priceUSD
    }

    private fun getPriceGBP(results: ArrayList<CurrentPriceEntity.Bpi.GBP?>) : ArrayList<CurrentPrice.Bpi.GBP> {
        val priceGBP = ArrayList<CurrentPrice.Bpi.GBP>()
        results.map { data ->
            priceGBP.add(
                CurrentPrice.Bpi.GBP(
                    code = data?.code ?: "",
                    symbol = data?.symbol ?: "",
                    rate = data?.rate ?: "",
                    description = data?.description ?: "",
                    rateFloat = data?.rateFloat ?: 0.0
                )
            )
        }
        return priceGBP
    }

    private fun getPriceEUR(results: ArrayList<CurrentPriceEntity.Bpi.EUR?>) : ArrayList<CurrentPrice.Bpi.EUR> {
        val priceEUR = ArrayList<CurrentPrice.Bpi.EUR>()
        results.map { data ->
            priceEUR.add(
                CurrentPrice.Bpi.EUR(
                    code = data?.code ?: "",
                    symbol = data?.symbol ?: "",
                    rate = data?.rate ?: "",
                    description = data?.description ?: "",
                    rateFloat = data?.rateFloat ?: 0.0
                )
            )
        }
        return priceEUR
    }
}