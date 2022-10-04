package com.skedulo.techtest.backend

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonElement
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension
import kotlin.io.path.Path
import kotlin.io.path.readText

/**
 * These tests replicate the verify-music.sh script
 */
@ExtendWith(SpringExtension::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class ApplicationTests {

    private val basePath = "../../backend/music-schedule/verifier/"

    @Test
    fun `the tests pass for example json`() {
        testFileEquality("example")
    }

    @Test
    fun `the tests pass for minutes-resolution json`() {
        testFileEquality("minutes-resolution")
    }

    @Test
    fun `the tests pass for seconds-resolution json`() {
        testFileEquality("seconds-resolution")
    }

    @Test
    fun `the tests pass for overlapping json`() {
        testFileEquality("overlapping")
    }

    @Test
    fun `the tests pass for time-priority json`() {
        testFileEquality("time-priority")
    }

    @Test
    fun `the tests pass for timezone json`() {
        testFileEquality("timezone")
    }

    private fun testFileEquality(filename: String) {
        Application.main(arrayOf("${basePath}$filename.json"))

        val actualText = Path("${basePath}$filename.optimal.json").readText()
        val expectedText = Path("${basePath}$filename.optimal.json.expected").readText()

        val actual = Json.decodeFromString<JsonElement>(actualText)
        val expected = Json.decodeFromString<JsonElement>(expectedText)
        Assertions.assertEquals(expected, actual)
    }

}
