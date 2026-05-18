package com.github.johnnysc.practicetdd

class PagingViewModel(
    private val repository: PagingRepository,
    private val communication: Communication,
) {
    private val mapper = MessageMapper()
    fun init(isFirstRun: Boolean) {
        val result = repository.messages(
            strategy = PagingRepository.Strategy.INIT
        )
        communication.map(result.map(mapper::map))
    }

    fun loadMore() {
        val result = repository.messages(
            strategy = PagingRepository.Strategy.NEXT
        )
        communication.map(result.map(mapper::map))
    }

    fun loadPrevious() {
        val result = repository.messages(
            strategy = PagingRepository.Strategy.PREVIOUS
        )
        communication.map(result.map(mapper::map))
    }
}