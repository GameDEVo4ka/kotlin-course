package com.gamedevo4ka.kotlincourse.lesson22.extensions

//Задача 3: Переворот элементов пары
//Реализуйте метод расширения revert для класса Pair, который меняет местами первый и второй элементы пары. Метод должен возвращать новую пару с перевернутыми элементами. Протестируйте эту функцию на различных парах значений, в том числе null.

fun <A, B> Pair<A, B>.revert(): Pair<B, A> {
    return Pair(this.second, this.first)
}