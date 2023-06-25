package kr.toru.purekotlindomain.domain

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.client.request.get
import io.ktor.client.request.header
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import io.ktor.http.parametersOf
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json

private const val TIMEOUT = 6000
private const val URL = "https://api.agify.io/"

object HttpClient {
    private val httpClientAndroid = HttpClient(Android) {

        install(ContentNegotiation) {
            json(
                Json {
                    prettyPrint = true
                    isLenient = true
                    ignoreUnknownKeys = true
                }
            )


            engine {
                connectTimeout = TIMEOUT
                socketTimeout = TIMEOUT
            }
        }

        install(Logging) {
            logger = object : Logger {
                override fun log(message: String) {
                    println("Logger Ktor => $message")
                }

            }
            level = LogLevel.BODY
        }

        install(ResponseObserver) {
            onResponse { response ->
                println("HTTP status: ${response.status.value}")
            }
        }

        install(DefaultRequest) {
            header(
                key = HttpHeaders.ContentType,
                value = ContentType.Application.Json
            )
        }
    }

    suspend fun getTest(name: String): Response {
        return kotlin.runCatching {
            httpClientAndroid.get {
                url(urlString = URL)
                parameter(key = "name", value = name)
            }.body<Response>()
        }.getOrDefault(Response())
    }
}

@Serializable
data class Response(
    val count: Int = -1,
    val name: String = "empty",
    val age: Int = -1,
)