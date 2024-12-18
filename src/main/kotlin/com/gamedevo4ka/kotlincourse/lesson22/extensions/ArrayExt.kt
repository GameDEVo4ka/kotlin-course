package com.gamedevo4ka.kotlincourse.lesson22.extensions

//1.	Тренируемся составлять сигнатуру функции расширяющей класс. Можешь проявить свою творческую жилку и в коде функции что-нибудь сделать с входящими данными, чтобы вернуть итоговый результат или распечатать его, если нет возвращаемого типа.
//a.	Определите функцию-расширение для массива чисел, которая не принимает аргументов и возвращает пару из чисел.

fun IntArray.pair(): Pair<Int, Int>? {
    return if (this.isNotEmpty()) this.first() to this.last() else null
}