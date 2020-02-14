package com.example.dojokotlintests

import androidx.annotation.VisibleForTesting

class MoneyExchange(private val exchangeRateService: ExchangeRateService) {
    companion object {
        const val exchangeTax = 1.2
    }

    fun exchangeMoney(currency: String, amount: Double): ExchangeEntity {
        val price = exchangeRateService.getCurrencyPrice(currency)
        val totalValue = amount * price * exchangeTax
        return ExchangeEntity(totalValue, amount)
    }

    @VisibleForTesting
    fun Double.exchangeMoney(currency: String) = exchangeMoney(currency, this)
}

class ExchangeEntity(
    val priceReals: Double,
    val currencyAmount: Double)