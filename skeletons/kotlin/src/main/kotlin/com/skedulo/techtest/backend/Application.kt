package com.skedulo.techtest.backend

import kotlinx.datetime.*
import kotlinx.serialization.*
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * We are using Spring Boot here purely to make running against the verifier script simple, you shouldn't need to do
 * anything with it to run this, just execute ./backend/music-schedule/verifier/verify-music.sh ./run.sh from the root
 * of this project.
 *
 * We have pulled in kotlinx.serialization.* for JSON operations but you are welcome to use any library you wish for
 * this.
 *
 * Note that you should also use kotlinx.datetime.* alongside it so you get Instant, LocalDateTime, etc support
 * out of the box for serialization.
 *
 * You are also welcome to pull in any other libraries you feel are useful.
 */
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
