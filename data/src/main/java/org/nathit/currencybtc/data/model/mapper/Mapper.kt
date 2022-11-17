package org.nathit.currencybtc.data.model.mapper

interface Mapper<E, D> {
    fun map(input: E): D
}