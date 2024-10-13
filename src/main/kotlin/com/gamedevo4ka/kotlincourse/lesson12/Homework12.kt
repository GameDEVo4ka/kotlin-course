package com.gamedevo4ka.kotlincourse.lesson12

//Напиши валидную сигнатура метода
//●	Напишите сигнатуру функции, которая не принимает аргументов и не возвращает значения.
    fun fun1() {}

//●	Напишите сигнатуру функции, которая принимает два целых числа и возвращает их сумму.
    fun fun2(a: Int, b: Int) = a + b

//●	Напишите сигнатуру функции, которая принимает строку и ничего не возвращает.
    fun fun3(str: String) {}

//●	Напишите сигнатуру функции, которая принимает список целых чисел и возвращает среднее значение типа Double.
    fun fun4(numbers: List<Int>): Double {
    return numbers.average()
}

//●	Напишите сигнатуру функции, которая принимает nullable строку и возвращает её длину в виде nullable целого числа.
    fun fun5(value: String?): Int? {
    return value?.length
}

//●	Напишите сигнатуру функции, которая не принимает аргументов и возвращает nullable вещественное число.
    fun fun6(): Double? {
    return null
}

//●	Напишите сигнатуру функции, которая принимает nullable список целых чисел и не возвращает значения.
    fun fun7(list: List<Int?>) {
}

//●	Напишите сигнатуру функции, которая принимает целое число и возвращает nullable строку.
    fun fun8(int: Int): String? {
    return null
}

//●	Напишите сигнатуру функции, которая не принимает аргументов и возвращает список nullable строк.
    fun fun9(): List<String?> {
    return listOf(null)
}

//●	Напишите сигнатуру функции, которая принимает nullable строку и nullable целое число и возвращает nullable булево значение.
    fun fun10(str: String?, int: Int?): Boolean {
    return false
}

//
//Напиши рабочий код для следующих задач:
//Задача 1:
//Напишите функцию multiplyByTwo, которая принимает целое число и возвращает его, умноженное на 2.
fun multiplyByTwo(int: Int): Int {
    return int * 2
}

//________________________________________

//Задача 2:
//Создайте функцию isEven, которая принимает целое число и возвращает true, если число чётное, и false в противном случае.
fun isEven(int: Int): Boolean {
    return int % 2 == 0
}

//________________________________________

//Задача 3:
//Напишите функцию printNumbersUntil, которая принимает целое число n и выводит на экран числа от 1 до n. Если число n меньше 1, функция должна прекратить выполнение с помощью return без вывода сообщений.
fun printNumbersUntil(int: Int) {
    if (int < 1) return
    for (i in 1..int) {
        println(i)
    }
}

//________________________________________

//Задача 4:
//Создайте функцию findFirstNegative, которая принимает список целых чисел и возвращает первое отрицательное число в списке. Если отрицательных чисел нет, функция должна вернуть null.
fun findFirstNegative(list: List<Int>): Int? {
    for (i in list) {
        if (i < 0) return i
    }
    return null
}

//________________________________________

//Задача 5:
//Напишите функцию processList, которая принимает список строк. Функция должна проходить по списку и выводить каждую строку. Если встречается null значение, функция должна прекратить выполнение с помощью return без возврата значения.
fun processList(list: List<String?>) {
    for (i in list) {
        if (i == null) return
        println(i)
    }
}

//

//Сделай рефакторинг функции, через определение вспомогательных приватных функций. Требуется избавиться от дублирования кода и трудно воспринимаемых фрагментов.
//
//Сначала сделай запуск функции и посмотри на результат её работы. Сделай запуск после рефакторинга и проверь, чтобы результат работы был аналогичным.
//fun drawRectangle(width: Int, height: Int) {
//    if (width <= 0) throw IllegalArgumentException("width должно быть положительным и больше нуля")
//    if (height <= 0) throw IllegalArgumentException("height должно быть положительным и больше нуля")
//
//    // Верхняя граница
//    var topLine = "+"
//    for (i in 1 until width - 1) {
//        topLine += "-"
//    }
//    topLine += "+\n"
//    print(topLine)
//
//    // Боковые границы
//    for (i in 1 until height - 1) {
//        var middleLine = "|"
//        for (j in 1 until width - 1) {
//            middleLine += " "
//        }
//        middleLine += "|\n"
//        print(middleLine)
//    }
//
//    // Нижняя граница
//    var bottomLine = "+"
//    for (i in 1 until width - 1) {
//        bottomLine += "-"
//    }
//    bottomLine += "+\n"
//    print(bottomLine)
//

fun drawRectangle(width: Int, height: Int) {
    if (width <= 0) throw IllegalArgumentException("width должно быть положительным и больше нуля")
    if (height <= 0) throw IllegalArgumentException("height должно быть положительным и больше нуля")

    // Вспомогательная функция для рисования горизонтальной границы
    fun drawHorizontalBorder() {
        println("+" + "-".repeat(width - 2) + "+")
    }

    // Вспомогательная функция для рисования боковых границ
    fun drawVerticalBorders() {
        repeat(height - 2) {
            println("|" + " ".repeat(width - 2) + "|")
        }
    }
}

//
//Дополнительное задание для тех, кому очень скучно.
//
//Сделай рефакторинг функции, которую разбирали на уроке и устрани баг, из-за которого таблица разъезжается при разных размерностях аргументов
//
//fun printMap(xSize: Int, ySize: Int) {
//    if (xSize == 0) throw IllegalArgumentException("xSize не должно быть равным нулю")
//    if (ySize == 0) throw IllegalArgumentException("ySize не должно быть равным нулю")
//    val formatterSize = " $xSize".length
//    val xRange = if (xSize > 0) {
//        0..xSize
//    } else {
//        0 downTo xSize
//    }
//    val yRange = if (ySize > 0) {
//        0..ySize
//    } else {
//        0 downTo ySize
//    }
//    print(" ".repeat(formatterSize))
//    for (i in xRange) {
//        print("%${formatterSize}s".format(i))
//    }
//    println()
//    for (i in yRange) {
//        print("%${formatterSize}s".format(i))
//        for (j in yRange) {
//            val m = i * j
//            val result = when {
//                m % 2 == 0 -> if (m % 3 == 0) "." else "*"
//                m % 5 == 0 -> if (i < 0) "-" else "+"
//                else -> "?"
//            }
//            print("%${formatterSize}s".format(result))
//        }
//        println()
//    }
//}

fun printMap(xSize: Int, ySize: Int) {
    if (xSize == 0) throw IllegalArgumentException("xSize не должно быть равным нулю")
    if (ySize == 0) throw IllegalArgumentException("ySize не должно быть равным нулю")

    val formatterSize = " $xSize".length
    val xRange = if (xSize > 0) 0..xSize else 0 downTo xSize
    val yRange = if (ySize > 0) 0..ySize else 0 downTo ySize

    fun printHeader() {
        print(" ".repeat(formatterSize))
        for (i in xRange) {
            print("%${formatterSize}s".format(i))
        }
        println()
    }

    fun printRow(i: Int) {
        print("%${formatterSize}s".format(i))
        for (j in xRange) {
            val m = i * j
            val result = when {
                m % 2 == 0 -> if (m % 3 == 0) "." else "*"
                m % 5 == 0 -> if (i < 0) "-" else "+"
                else -> "?"
            }
            print("%${formatterSize}s".format(result))
        }
        println()
    }

    printHeader()
    for (i in yRange) {
        printRow(i)
    }
}