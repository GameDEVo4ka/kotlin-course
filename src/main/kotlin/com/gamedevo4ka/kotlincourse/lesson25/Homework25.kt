package com.gamedevo4ka.kotlincourse.lesson25

//Задание 1. Создай константу в файле с текстом. Создай функцию, которая ничего не принимает и не возвращает и печатает в консоль текст константы.
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Создай лямбда выражение без указания типа.
//Проверь как функция работает

const val TEXT = "Текст"

fun main() {
    fun printText() {
        println(TEXT)
    }

    val anonymousFunction = fun() {
        println(TEXT)
    }

    val lambdaWithTypes: () -> Unit = {
        println(TEXT)
    }

    val lambdaWithoutTypes = {
        println(TEXT)
    }

        printText()
        anonymousFunction()
        lambdaWithTypes()
        lambdaWithoutTypes()

//Задание 2. Создай функцию, которая принимает список чисел и возвращает среднее арифметическое этого списка. С помощью require проверь, что список не пустой.
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Создай лямбда выражение без указания типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных (в том числе пустого).

    fun average(numbers: List<Int>): Double {
        require(numbers.isNotEmpty()) { "Список не может быть пустым!" }
        return numbers.average()
    }

    val anonymousAverage = fun(numbers: List<Int>): Double {
        require(numbers.isNotEmpty()) { "Список не может быть пустым!" }
        return numbers.average()
    }

    val lambdaAverageWithTypes: (List<Int>) -> Double = {
        require(it.isNotEmpty()) { "Список не может быть пустым!" }
        it.average()
    }

    val lambdaAverageWithoutTypes = { numbers: List<Int> ->
        require(numbers.isNotEmpty()) { "Список не может быть пустым!" }
        numbers.average()
    }
        println(lambdaAverageWithTypes(listOf(1, 2, 3, 4, 5)))
        println(lambdaAverageWithTypes(emptyList()))

//Задание 3. Создай функцию, которая принимает список строк и число, а возвращает список из строк, длина которых больше или равна заданному числу. Если список пуст, нужно выкинуть исключение.
//По аналогии с предыдущим заданием выполни трансформации и проверки.

    fun filterStringsByLength(strings: List<String>, length: Int): List<String> {
        require(strings.isNotEmpty()) { "Список не может быть пустым!" }
        return strings.filter { it.length >= length }
    }

    val anonymousFilterStrings = fun(strings: List<String>, length: Int): List<String> {
        require(strings.isNotEmpty()) { "Список не может быть пустым!" }
        return strings.filter { it.length >= length }
    }

    val lambdaFilterStringsWithTypes: (List<String>, Int) -> List<String> = { strings, length ->
        require(strings.isNotEmpty()) { "Список не может быть пустым!" }
        strings.filter { it.length >= length }
    }

    val lambdaFilterStringsWithoutTypes = { strings: List<String>, length: Int ->
        require(strings.isNotEmpty()) { "Список не может быть пустым!" }
        strings.filter { it.length >= length }
    }

        println(lambdaFilterStringsWithTypes(listOf("item1", "item2", "item3"), 5))
        println(lambdaFilterStringsWithTypes(emptyList(), 5))

//Задание 4. Создай функцию, которая принимает большое число и возвращает сумму цифр этого числа.
//По аналогии с предыдущим заданием выполни трансформации и проверки.
//Подсказка: для парсинга строки “3” в число 3 можно использовать “3”.digitToInt()

    fun sumOfDigits(number: Int): Int {
        return number.toString().sumOf { it.digitToInt() }
    }

    val anonymousSumOfDigits = fun(number: Int): Int {
        return number.toString().sumOf { it.digitToInt() }
    }

    val lambdaSumOfDigitsWithTypes: (Int) -> Int = {
        it.toString().sumOf { char -> char.digitToInt() }
    }

    val lambdaSumOfDigitsWithoutTypes = { number: Int ->
        number.toString().sumOf { it.digitToInt() }
    }

        println(lambdaSumOfDigitsWithTypes(1234))

//Задание 5. Создай функцию расширение списка чисел, которая будет возвращать список уникальных чисел (без дубликатов).
//Создай аналогичную анонимную функцию.
//Создай аналогичное лямбда выражение с указанием типа.
//Проверь, что лямбда выражение работает правильно с помощью нескольких наборов данных.

    fun List<Int>.uniqueNumbers(): List<Int> {
        return this.distinct()
    }

    val anonymousUniqueNumbers = fun(numbers: List<Int>): List<Int> {
        return numbers.distinct()
    }

    val lambdaUniqueNumbersWithTypes: (List<Int>) -> List<Int> = {
        it.distinct()
    }

    val lambdaUniqueNumbersWithoutTypes = { numbers: List<Int> ->
        numbers.distinct()
    }
        println(lambdaUniqueNumbersWithTypes(listOf(1, 2, 2, 3, 4, 4)))

//Задание 6. Создай функцию расширение словаря из строк и чисел, которая принимает число и возвращает список ключей, длина которых меньше их значений но больше заданного в функции аргумента. В случае если список получается пустой нужно выкинуть исключение IllegalState.
//По аналогии с предыдущим заданием выполни трансформации и проверки.

    fun Map<String, Int>.filterKeysByLength(minLength: Int): List<String> {
        val result = this.filter { (key, value) -> key.length < value && key.length > minLength }.keys.toList()
        if (result.isEmpty()) throw IllegalStateException("Нет ключей, соответствующих условию")
        return result
    }

    val anonymousFilterKeys = fun(map: Map<String, Int>, minLength: Int): List<String> {
        val result = map.filter { (key, value) -> key.length < value && key.length > minLength }.keys.toList()
        if (result.isEmpty()) throw IllegalStateException("Нет ключей, соответствующих условию")
        return result
    }

    val lambdaFilterKeysWithTypes: (Map<String, Int>, Int) -> List<String> = { map, minLength ->
        val result = map.filter { (key, value) -> key.length < value && key.length > minLength }.keys.toList()
        if (result.isEmpty()) throw IllegalStateException("Нет ключей, соответствующих условию")
        result
    }

        val testMap = mapOf("item1" to 1, "item2" to 2, "item3" to 3)
        println(lambdaFilterKeysWithTypes(testMap, 2))

//Задание 7. Создай функцию расширения словаря из списка и множества, которая принимает все известные тебе типы (вспомни все что знаешь и под каждый тип создай аргумент) и возвращает строку. Функция должна распечатать все данные, которые тебе в ней доступны и вернуть конкатенацию всех данных которые ей доступны (порядок неважен). Конкатенация - это присоединение. Код должен быть отформатирован таким образом, чтобы легко читался.
//По аналогии с предыдущим заданием выполни трансформации.

    fun <K, V> Map<K, V>.describeContents(
        list: List<Any>, set: Set<Any>, map: Map<Any, Any>, number: Number, text: String
    ): String {
        val allData = listOf(this.toString(), list.toString(), set.toString(), map.toString(), number.toString(), text)
        return allData.joinToString(separator = ", ")
    }

    val anonymousDescribeContents = fun(map: Map<Any, Any>, list: List<Any>, set: Set<Any>, mapArg: Map<Any, Any>, number: Number, text: String): String {
        val allData = listOf(map.toString(), list.toString(), set.toString(), mapArg.toString(), number.toString(), text)
        return allData.joinToString(separator = ", ")
    }

    val lambdaDescribeContentsWithTypes: (Map<Any, Any>, List<Any>, Set<Any>, Map<Any, Any>, Number, String) -> String = { map, list, set, mapArg, number, text ->
        val allData = listOf(map.toString(), list.toString(), set.toString(), mapArg.toString(), number.toString(), text)
        allData.joinToString(separator = ", ")
    }

    val testMap = mapOf<Any, Any>("item1" to 1, "item2" to "value")
    println(lambdaDescribeContentsWithTypes(testMap, listOf("x", 1, 1.5), setOf("y", 10), mapOf("c" to 5), 50, "Text"))
}
