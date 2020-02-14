package com.example.dojokotlintests

import io.kotlintest.matchers.doubles.shouldBeExactly
import io.kotlintest.specs.AnnotationSpec
import io.mockk.MockKAnnotations
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import io.mockk.unmockkAll

class MoneyExchangeTests: AnnotationSpec() {

    @MockK
    lateinit var serviceMock: ExchangeRateService

    val moneyExchange by lazy { com.example.dojokotlintests.MoneyExchange(serviceMock) }

    @BeforeEach
    fun setup() {
        MockKAnnotations.init(this)
    }

    @After
    fun cc() {
        unmockkAll()
    }

    @Test
    fun exchangeDollars() {
        every {
            serviceMock.getCurrencyPrice("USS")
        } returns 2.5
        val result = moneyExchange.exchangeMoney("USS", 10.0)
        result.currencyAmount shouldBeExactly 10.0
        result.priceReals shouldBeExactly 30.0
    }

    @Test
    fun extensionTest() {
        with(moneyExchange) {
            val result = 10.0.exchangeMoney("USS")
            result.currencyAmount shouldBeExactly 10.0
            result.priceReals shouldBeExactly 30.0
        }
    }
}
