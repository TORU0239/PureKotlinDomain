package kr.toru.purekotlindomain.usecase

import kr.toru.purekotlindomain.data.ExampleResponse

interface ExampleUseCase {
    suspend fun getInfo(name: String): ExampleResponse
}