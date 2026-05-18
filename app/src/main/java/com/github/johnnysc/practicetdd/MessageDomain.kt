package com.github.johnnysc.practicetdd

sealed interface MessageDomain {
    object LoadPrevious : MessageDomain
    object LoadMore : MessageDomain
    data class Base(
        val id: Int,
        val text: String,
    ) : MessageDomain
}