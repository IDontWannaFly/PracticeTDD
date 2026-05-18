package com.github.johnnysc.practicetdd

sealed class LoginState {
    data class TwoErrors(
        val loginError: String,
        val passwordError: String
    ) : LoginState()

    data class EmailError(val value: String) : LoginState()
    data class PasswordError(val value: String) : LoginState()
    data class Error(val value: WeatherUiModel) : LoginState()
    data class Success(val value: WeatherUiModel) : LoginState()
}