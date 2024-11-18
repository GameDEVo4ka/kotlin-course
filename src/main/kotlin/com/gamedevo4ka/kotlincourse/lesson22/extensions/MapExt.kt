package com.gamedevo4ka.kotlincourse.lesson22.extensions

//d.	Реализуйте функцию-расширение для класса словаря допускающего null с ключами дженериком и значениями типа список из такого же дженерика, которая принимает один аргумент типа число и возвращает словарь допускающий null с ключами типа строка и значениями типа дженерика допускающего null.

fun <K, V> Map<K, List<V>>?.transformToMap(number: Int): Map<String, V?>? {
    if (this == null) return null
    return this.entries.associate { (key, value) ->
        key.toString() to value.getOrNull(number)
    }
}