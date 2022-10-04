package com.skedulo.techtest.backend

import kotlinx.datetime.*
import kotlinx.serialization.*
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            val inputFilePath = args.first()
            println(inputFilePath)
        }
    }
}
