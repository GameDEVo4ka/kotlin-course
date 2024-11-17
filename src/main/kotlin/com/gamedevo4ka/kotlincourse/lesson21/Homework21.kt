package com.gamedevo4ka.kotlincourse.lesson21

//Требуется описать класс, интерфейс или функцию и реализовать предложенную логику в коде.
//

fun main() {
    println(toMap(listOf<Int>(), listOf<String>()))
    println(toMap(listOf<Int>(1, 2), listOf<String>("ready")))
    println(toMap(listOf<Int>(2), listOf<String>("set", "ready")))

    println(getMiddleElement(listOf()))
    println(getMiddleElement(listOf(1, 2, 3)))

    val holder = ListHolder(mutableListOf<Int>())
    holder.addItem(123)
    print(holder.getItems())

    println(PhrasesToListOfStrings().transform("Text 123"))

    val list1 = listOf("123", "456", "789")
    println(PhrasesToListOfStrings().transformList(list1))

    println(StringValidator().check(""))
    println(StringValidator().check(" "))
    println(StringValidator().check(null))
    println(StringValidator().check("Text"))

    println(OddValidator().check(0))
    println(OddValidator().check(1))

    println(ListValidator<Number>().check(listOf()))
    println(ListValidator<Number>().check(listOf(null)))
    println(ListValidator<Number>().check(listOf(1, 2, 3)))
    println(ListValidator<Number>().check(listOf(4, 5, 6)))
}

//1.	Создайте функцию toMap<K, V>(keys: List<K>, values: List<V>): Map<K, V>, которая будет создавать карту из списков ключей и значений. Если ключей или значений больше, то оставшиеся ключи или значения не записываем в словарь.

fun <K, V> toMap (keys: List<K>, values: List<V>): Map<K, V> {
    val res = mutableMapOf<K, V>()
    val size = minOf(keys.size, values.size)
    for (i in 0 until size) {
        res[keys[i]] = values[i]
    }
    return res
}

//2.	Напишите функцию getMiddleElement<T>(list: List<T>): T?, которая будет возвращать средний элемент списка, если он существует.

fun <T> getMiddleElement(list: List<T>): T? {
    if (list.isNotEmpty()) {
        return list[list.size / 2]
    }
    return null
}


