package com.gamedevo4ka.kotlincourse.lesson21

//8.	Создай класс StringValidator и имплементируй интерфейс Validator с типом String?. Реализуй проверку, что строка не является null, не пустая и не состоит из одних пробелов.

class StringValidator : Validator<String?> {
    override fun check(str: String?) = !str.isNullOrBlank()
}