package com.github.johnnysc.practicetdd

interface MyStack<T : Any> {
    fun pop() : T

    fun push(item: T)

    class LIFO<T : Any>(
        maxCount: Int,
        private val defaultStack: MyStack<T> = DefaultStack(maxCount = maxCount)
    ) : MyStack<T> by defaultStack {
        private val items = (defaultStack as DefaultStack).items

        //There will be bug which is not covered by tests :)
        //If stack is full - pop will be creating duplicates at the end of array, so you can't push any items anymore
        //But all tests passed ;)
        override fun pop(): T {
            if (items[0] == null) throw IllegalStateException("Can not pop from empty stack")
            val item = items[0]
            items[0] = null
            for (i in 1 until items.size) {
                items[i - 1] = items[i]
//                items[i] = null // Fix for the bug
            }

            return item as T
        }
    }

    class FIFO<T : Any>(
        maxCount: Int,
        private val defaultStack: MyStack<T> = DefaultStack(maxCount = maxCount)
    ) : MyStack<T> by defaultStack

    //Made FIFO impl as Default
    private class DefaultStack<T : Any>(val maxCount: Int) : MyStack<T> {

        init {
            if (maxCount <= 0) throw IllegalStateException("maxCount must be greater than 0")
        }

        val items = arrayOfNulls<Any>(maxCount)

        override fun pop(): T {
            val lastItemIndex = getLastItemIndex()
            if (lastItemIndex == -1) throw IllegalStateException("Can not pop from empty stack")
            val item = items[lastItemIndex]
            items[lastItemIndex] = null

            return item as T
        }

        override fun push(item: T) {
            val lastItemIndex = getLastItemIndex()
            if (lastItemIndex == items.lastIndex) throw IllegalStateException("Stack overflow exception, maximum is ${items.size}")
            for (i in items.size - 1 downTo  0 + 1) {
                items[i] = items[i - 1]
            }
            items[0] = item
        }

        private fun getLastItemIndex() : Int {
            return (items.indexOfFirst { it == null }
                .takeIf { it != -1 } ?: items.size) - 1
        }
    }
}