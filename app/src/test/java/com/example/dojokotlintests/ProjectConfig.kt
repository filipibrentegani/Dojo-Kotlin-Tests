package io.kotlintest.provided

import io.kotlintest.AbstractProjectConfig

object ProjectConfig: AbstractProjectConfig() {
    override fun parallelism(): Int {
        return 2
    }

    override fun beforeAll() {
        println("EITAAAAAAAAAAAAA")
        super.beforeAll()
    }
}