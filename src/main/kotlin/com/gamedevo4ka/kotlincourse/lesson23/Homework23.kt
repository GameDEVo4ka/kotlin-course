package com.gamedevo4ka.kotlincourse.lesson23

fun main() {
    //Задача 1
//Напишите функцию analyzeDataType, принимающую параметр типа Any. Функция должна определить тип аргумента и вывести соответствующее сообщение:
//●	Для строки: "Это строка: [значение]".
//●	Для целого числа: "Это целое число: [значение]".
//●	Для списка: "Это список, количество элементов: [количество]".
//●	Для карты: "Это карта, количество пар: [количество]".
//●	Для остальных типов: "Неизвестный тип данных".
//Используйте оператор is для проверки типов.
    fun analyzeDataType(value: Any) {
        when (value) {
            is String -> println("Это строка: $value")
            is Int -> println("Это целое число: $value")
            is List<*> -> println("Это список, количество элементов: ${value.size}")
            is Map<*, *> -> println("Это карта, количество пар: ${value.size}")
            else -> println("Неизвестный тип данных")
        }
    }

//Задача 2
//Создайте функцию safeCastToList, принимающую параметр типа Any и возвращающую размер списка, если аргумент можно безопасно привести к типу List. В случае неудачного приведения функция должна возвращать -1.
//Используйте as? для безопасного приведения типа.
fun safeCastToList(value: Any): Int {
    return (value as? List<*>)?.size ?: -1
}

//Задача 3
//Создайте функцию getStringLengthOrZero, которая принимает параметр типа Any? и возвращает длину строки, если аргумент можно привести к типу String. В случае, если аргумент равен null или не является строкой, функция должна возвращать 0.
fun getStringLengthOrZero(value: Any?): Int {
    return (value as? String)?.length ?: 0
}

//Задача 4
//Создайте функцию, которая принимает параметр типа Any.
//Функция гарантированно ожидает число (в виде числа или строки, например 4 или 4.2 или “4.2”) и должна вернуть квадрат этого числа. Если придёт число, его нужно возвести в квадрат, если придёт строка, то его нужно преобразовать в число через функцию toDouble() и возвести в квадрат.
fun squareNumber(value: Any): Double {
    return when (value) {
        is Number -> value.toDouble() * value.toDouble()
        is String -> value.toDoubleOrNull()?.let { it * it } ?: throw IllegalArgumentException("Строка не является допустимым числом")
        else -> throw IllegalArgumentException("Не строка и не число")
    }
}

//Задача 5
//Напишите функцию sumIntOrDoubleValues, которая принимает список элементов типа Any и возвращает сумму всех целочисленных (Int) и вещественных (Double) значений в списке. Все остальные типы должны быть проигнорированы.
fun sumIntOrDoubleValues(list: List<Any>): Double {
    var sum = 0.0
    for (element in list) {
        when (element) {
            is Int -> sum += element
            is Double -> sum += element
        }
    }
    return sum
}

//Задача 6
//Создайте функцию tryCastToListAndPrint, которая принимает параметр типа Any и пытается привести его к типу List<*>. Если приведение успешно, функция должна напечатать все строки из списка, если элемент не является строкой то вывести предупреждение об этом. Если приведение неудачно, должно быть выведено сообщение об ошибке, не прерывая выполнение программы.
fun tryCastToListAndPrint(value: Any) {
    val list = value as? List<*>
    if (list != null) {
        for (element in list) {
            if (element is String) {
                println(element)
            } else {
                println("Элемент не является строкой: $element")
            }
        }
    } else {
        println("Значение не является списком")
    }
}

    println("------- Task 1 -------")
    analyzeDataType("String")
    analyzeDataType(10)
    analyzeDataType(listOf(1, 2, 3, 4, 5, 6, 7))
    analyzeDataType(mapOf("1" to "a"))
    analyzeDataType(1.5)

    println("------- Task 2 -------")
    println(safeCastToList(listOf(1, 2, 3, 4, 5, 6, 7)))  // 3
    println(safeCastToList("Не список"))  // -1

    println("------- Task 3 -------")
    println(getStringLengthOrZero("String"))  // 5
    println(getStringLengthOrZero(null))  // 0
    println(getStringLengthOrZero(100))  // 0

    println("------- Task 4 -------")
    println(squareNumber(4))  // 16.0
    println(squareNumber("4.2"))  // 17.64

    println("------- Task 5 -------")
    println(sumIntOrDoubleValues(listOf(1, 1.5, "string", 2L, 5)))  // 6.5
    println(sumIntOrDoubleValues(listOf("a", "b", "c", "d", "e", "f", "g")))  // 0.0

    println("------- Task 6 -------")
    tryCastToListAndPrint(listOf("Hello", "World", 123))
    tryCastToListAndPrint("Значение не является списком")
}