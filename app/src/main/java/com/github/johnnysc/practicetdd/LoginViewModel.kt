package com.github.johnnysc.practicetdd

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch

class LoginViewModel(
    private val communication: LoginCommunication,
    private val interactor: LoginInteractor,
    private val mapper: WeatherUiMapper<WeatherUiModel>,
    private val validateEmail: UiValidator,
    private val validatePassword: UiValidator,
    dispatchers: DispatchersList
) {

    private val scope = CoroutineScope(SupervisorJob() + dispatchers.ui())

    fun login(email: String, password: String) = scope.launch {
        val isEmailValid = validateEmail.isValid(email)
        val isPasswordValid = validatePassword.isValid(password)

        //Check validation errors
        when {
            isEmailValid.not() && isPasswordValid.not() -> LoginState.TwoErrors(
                loginError = validateEmail.errorMessage(),
                passwordError = validatePassword.errorMessage(),
            )

            isEmailValid.not() -> LoginState.EmailError(
                value = validateEmail.errorMessage(),
            )

            isPasswordValid.not() -> LoginState.PasswordError(
                value = validatePassword.errorMessage(),
            )

            else -> null
        }?.let {
            communication.map(it)
            return@launch
        }

        //Make request and parse result
        val state = when (val result = interactor.login()) {
            is WeatherItem.Basic -> LoginState.Success(
                value = mapper.map(
                    feelsLike = result.feelsLike,
                    description = result.description,
                    temp = result.temp,
                )
            )
            is WeatherItem.Error -> LoginState.Error(
                mapper.map(
                    exceptionType = result.exceptionType
                )
            )
        }
        communication.map(
            source = state
        )
    }

}
