package kr.toru.purekotlindomain.data

import kotlinx.serialization.Serializable

@Serializable
data class ExampleResponse(
    val count: Int = -1,
    val name: String = "empty",
    val age: Int = -1,
)