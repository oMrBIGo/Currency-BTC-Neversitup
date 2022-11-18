package org.nathit.currencybtc.data.model.mapper

import org.nathit.currencybtc.data.model.CurrentPriceEntity
import org.nathit.currencybtc.domain.model.CurrentPrice

class CurrentPriceMapper : Mapper<CurrentPriceEntity, CurrentPrice> {

    override fun map(input: CurrentPriceEntity): CurrentPrice {
        return with(input) {
            CurrentPrice(
                time = CurrentPrice.Time(
                    updated = time.updated ?: "",
                    updateduk = time.updateduk ?: "",
                    updatedISO = time.updatedISO ?: ""
                ),
                disclaimer = this.disclaimer ?: "",
                chartName = this.chartName ?: "",
                bpi = CurrentPrice.Bpi(
                    eUR = CurrentPrice.Bpi.EUR(
                        code = bpi.eUR.code ?: "",
                        description = bpi.eUR.description ?: "",
                        rate = bpi.eUR.rate ?: "",
                        rateFloat = bpi.eUR.rateFloat ?: 0.0,
                        symbol = bpi.eUR.symbol ?: ""
                    ),
                    gBP = CurrentPrice.Bpi.GBP(
                        code = bpi.gBP.code ?: "",
                        description = bpi.gBP.description ?: "",
                        rate = bpi.gBP.rate ?: "",
                        rateFloat = bpi.gBP.rateFloat ?: 0.0,
                        symbol = bpi.gBP.symbol ?: ""
                    ),
                    uSD = CurrentPrice.Bpi.USD(
                        code = bpi.uSD.code ?: "",
                        description = bpi.uSD.description ?: "",
                        rate = bpi.uSD.rate ?: "",
                        rateFloat = bpi.uSD.rateFloat ?: 0.0,
                        symbol = bpi.uSD.symbol ?: ""
                    )
                )
            )
        }
    }

}