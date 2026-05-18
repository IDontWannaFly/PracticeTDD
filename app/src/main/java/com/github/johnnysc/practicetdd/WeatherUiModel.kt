package com.github.johnnysc.practicetdd

data class WeatherUiModel(
    val description: String,
    val isError: Boolean = false,
)