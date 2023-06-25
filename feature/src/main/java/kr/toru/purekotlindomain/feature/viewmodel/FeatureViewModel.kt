package kr.toru.purekotlindomain.feature.viewmodel

import androidx.lifecycle.ViewModel
import kr.toru.purekotlindomain.data.ExampleResponse
import kr.toru.purekotlindomain.usecase.ExampleUseCase
import kr.toru.purekotlindomain.usecase.impl.ExampleUseCaseImpl

class FeatureViewModel: ViewModel() {
    private val useCase: ExampleUseCase = ExampleUseCaseImpl()

    suspend fun getInfo(name: String): ExampleResponse {
        return useCase.getInfo(name)
    }
}