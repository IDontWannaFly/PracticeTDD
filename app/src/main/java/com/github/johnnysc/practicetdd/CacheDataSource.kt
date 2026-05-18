package com.github.johnnysc.practicetdd

interface CacheDataSource {

    fun add(item: SimpleData)
    fun data(): List<SimpleData>
    class Timed(val now: Now, val lifeTimeMillis: Long) : CacheDataSource {

        private val _items = arrayListOf<Item>()

        override fun add(item: SimpleData) {
            _items.add(Item(timestamp = now.now(), item))
            clearOutdated()
        }

        override fun data(): List<SimpleData> {
            clearOutdated()
            return _items.map { it.value }
        }

        private fun clearOutdated() {
            _items.removeAll { now.now() - it.timestamp > lifeTimeMillis }
        }

        data class Item(val timestamp: Long, val value: SimpleData)
    }
}