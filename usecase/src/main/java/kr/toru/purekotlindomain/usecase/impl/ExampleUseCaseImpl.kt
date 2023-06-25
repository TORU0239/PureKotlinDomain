package kr.toru.purekotlindomain.usecase.impl

import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.parameter
import io.ktor.client.request.url
import kr.toru.purekotlindomain.data.ExampleResponse
import kr.toru.purekotlindomain.domain.NetworkClient
import kr.toru.purekotlindomain.usecase.ExampleUseCase

class ExampleUseCaseImpl: ExampleUseCase {
    override suspend fun getInfo(name: String): ExampleResponse {
        return kotlin.runCatching {
            NetworkClient.httpClientAndroid.get {
                url(urlString = URL)
                parameter(key = REQ_PARAM_NAME, value = name)
            }.body<ExampleResponse>()
        }.getOrDefault(ExampleResponse())
    }

    companion object {
        private const val URL = "https://api.agify.io/"
        private const val REQ_PARAM_NAME = "name"
    }
}