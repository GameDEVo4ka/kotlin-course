package com.gamedevo4ka.kotlincourse.lesson21

//4.	Создайте интерфейс Mapper<T, R>, который будет определять метод для преобразования элементов типа T в элементы типа R.

interface Mapper<T, R> {
    fun transform(elem: T): R

//6.	Добавь к интерфейсу Mapper ещё один метод, который будет преобразовывать список элементов типа T в список элементов типа R. Реализуй этот метод в классе PhrasesToListOfStrings с аналогичной механикой.

    fun transformList(list: List<T>): List<R>
}