package com.gamedevo4ka.kotlincourse.lesson22.extensions

//e.	Определите функцию-расширение для класса длинного числа, допускающее null, которая не принимает аргументов и возвращает строку.

fun Long?.toCustomString(): String {
    return this?.toString() ?: "null"
}
