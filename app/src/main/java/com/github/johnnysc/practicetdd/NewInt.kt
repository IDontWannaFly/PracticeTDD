package com.github.johnnysc.practicetdd

interface NewInt {
    fun isValid(number: Int) : Boolean

    abstract class Decorator(
        protected val wrappee: NewInt
    ) : NewInt

    private object DefInt : NewInt {
        override fun isValid(number: Int): Boolean = true
    }

    class Positive(wrappee: NewInt = DefInt) : Decorator(
        wrappee = wrappee
    ) {
        override fun isValid(number: Int): Boolean {
            return wrappee.isValid(number).and(number >= 0)
        }
    }

    class Negative(wrappee: NewInt = DefInt) : Decorator(
        wrappee = wrappee
    ) {
        override fun isValid(number: Int): Boolean {
            return wrappee.isValid(number).and(number < 0)
        }
    }

    class Odd(wrappee: NewInt = DefInt) : Decorator(
        wrappee = wrappee
    ) {
        override fun isValid(number: Int): Boolean {
            return wrappee.isValid(number).and(number % 2 != 0)
        }
    }

    class Less(
        private val limit: Int,
        wrappee: NewInt = DefInt
    ) : Decorator(
        wrappee = wrappee
    ) {
        override fun isValid(number: Int): Boolean {
            return wrappee.isValid(number).and(number < limit)
        }
    }
}