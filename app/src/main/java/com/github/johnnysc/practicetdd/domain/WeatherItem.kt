package com.github.johnnysc.practicetdd.domain

import com.github.johnnysc.practicetdd.domain.ExceptionType

sealed class WeatherItem{
    data class Error(val exceptionType: ExceptionType) : WeatherItem()
    data class Basic(val description: String, val temp: Int, val feelsLike: Int) : WeatherItem()
}