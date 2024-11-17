package com.gamedevo4ka.kotlincourse.lesson21

//5.	Создай класс PhrasesToListOfStrings и имплементируй интефрейс Mapper с типами String и List<String>. Метод преобразования должен разбивать входящую строку по символу пробела и возвращать список из полученных слов.

class PhrasesToListOfStrings : Mapper<String, List<String>> {
    override fun transform(str: String) = str.split(" ")
    override fun transformList(list: List<String>) = list.map { transform(it) }
}