package com.skedulo.techtest.backend

import kotlinx.serialization.json.*
import org.springframework.boot.autoconfigure.SpringBootApplication

@SpringBootApplication
class Application {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            println("Input file name: ${args.first()}")

        }
    }

}
