package org.nathit.currencybtc.data.db.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Eur(
    var code: String = "",
    var description: String = "",
    var rate: String = "",
    var rateFloat: Double = 0.0,
    var symbol: String = ""
) {
    @PrimaryKey(autoGenerate = true) var id: Int = 0
}