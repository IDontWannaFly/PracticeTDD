package com.github.johnnysc.practicetdd

interface PagingRepository {

    fun messages(strategy: PagingRepository.Strategy): List<MessageDomain>
    enum class Strategy {
        INIT,
        NEXT,
        PREVIOUS
    }
}