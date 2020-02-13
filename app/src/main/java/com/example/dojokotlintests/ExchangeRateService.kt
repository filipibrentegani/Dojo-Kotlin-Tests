package com.example.dojokotlintests

interface ExchangeRateService {
    fun getCurrencyPrice(currency: String): Double
}