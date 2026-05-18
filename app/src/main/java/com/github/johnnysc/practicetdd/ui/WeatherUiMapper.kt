package com.github.johnnysc.practicetdd.ui

import com.github.johnnysc.practicetdd.domain.ExceptionType

interface WeatherUiMapper<T> {
    fun map(feelsLike: Int, description: String, temp: Int) : T
    fun map(exceptionType: ExceptionType) : T
}