package com.github.johnnysc.practicetdd.ui

interface UiValidator {
    fun errorMessage(): String

    fun isValid(text: String): Boolean
}