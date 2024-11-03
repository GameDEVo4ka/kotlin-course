package com.gamedevo4ka.kotlincourse.lesson18

//Задания для отработки переопределения методов
//3.	Принтер
//●	Создай абстрактный принтер, который имеет абстрактный метод печати, принимающий в качестве аргумента строку.
//●	Создай классы наследники: лазерный и струйный
//●	Лазерный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно чёрными буквами на белом фоне (хорошо работает на тёмной теме)
//●	Струйный принтер должен разбивать фразу на слова по пробелу и выводить каждое слово отдельно цветными буквами на цветном фоне. Слова должны быть разноцветны. Можно сделать список пар с цветом текста и фона и проходить циклически по этому списку при выводе текста. Проверить работу на длинном тексте.
//●	Подумать, как бы вынести в protected метод базового класса общую для обоих классов логику и избавиться от дублирования кода.

abstract class Printer {
    abstract fun print(text: String)
    protected fun splitText(text: String): List<String> {
        return text.split(" ")
        }
}

class LaserPrinter : Printer() {
    override fun print(text: String) {
        val words = splitText(text)
        println("Printing with LaserPrinter:")
        words.forEach { word ->
            println("\u001b[30;47m$word\u001b[0m")
            }
        }
}

class InkjetPrinter : Printer() {
    private val colors = listOf(
        Pair("\u001b[31;42m", "\u001b[0m"),
    Pair("\u001b[32;43m", "\u001b[0m"),
    Pair("\u001b[33;44m", "\u001b[0m"),
    Pair("\u001b[34;45m", "\u001b[0m"),
    Pair("\u001b[35;46m", "\u001b[0m")
    )

    override fun print(text: String) {
        val words = splitText(text)
        println("Printing with InkjetPrinter:")
        var colorIndex = 0
        words.forEach { word ->
            println("${colors[colorIndex].first}$word${colors[colorIndex].second}")
            colorIndex = (colorIndex + 1) % colors.size
            }
        }
}