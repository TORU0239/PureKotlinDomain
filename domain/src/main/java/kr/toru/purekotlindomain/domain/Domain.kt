package kr.toru.purekotlindomain.domain

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class Domain {
    fun test() = "TEST!!"

    suspend fun test1() = withContext(Dispatchers.IO) {

    }
}