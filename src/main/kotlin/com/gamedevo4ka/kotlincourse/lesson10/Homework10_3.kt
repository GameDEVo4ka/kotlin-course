package com.gamedevo4ka.kotlincourse.lesson10

//Работа с Множествами Set
//Задание 1: Создание Пустого Множества
//Создайте пустое неизменяемое множество целых чисел.
val set1 = setOf<Int>()

//Задание 2: Создание и Инициализация Множества
//Создайте неизменяемое множество целых чисел, содержащее три различных элемента (например, 1, 2, 3).
val set2 = setOf(1, 2, 3)

//Задание 3: Создание Изменяемого Множества
//Создайте изменяемое множество строк и инициализируйте его несколькими значениями (например, "Kotlin", "Java", "Scala").
val set3 = mutableSetOf("Kotlin", "Java", "Scala")

//Задание 4: Добавление Элементов в Множество
//Имея изменяемое множество строк, добавьте в него новые элементы (например, "Swift", "Go").
val set4 = mutableSetOf("Kotlin", "Java", "Scala")
set4.add("Swift")
set4.add("Go")

//Задание 5: Удаление Элементов из Множества
//Имея изменяемое множество целых чисел, удалите из него определенный элемент (например, 2).
val set5 = mutableSetOf(1, 2, 3)
set5.remove(2)

//Задание 6: Перебор Множества в Цикле
//Создайте множество целых чисел и используйте цикл для вывода каждого элемента на экран.
val set6 = setOf(1, 2, 3, 4, 5)
for (i in set6) {
    println(i)
}

//Задание 7: Проверка Наличия Элемента в Множестве
//Создай функцию, которая принимает множество строк (set) и строку и проверяет, есть ли в множестве указанная строка. Нужно вернуть булево значение true если строка есть. Реши задачу через цикл.
fun checkStringInSet(set: Set<String>, string: String): Boolean {
    for (element in set) {
        if (element == string) {
            return true
        }
    }
    return false
}

//Задание 8: Объединение Двух Множеств
//Создайте два множества строк и объедините их в одно новое множество, содержащее все уникальные элементы обоих множеств. Реши задачу с помощью циклов.
val set8 = setOf("one", "two", "three")
val set8a = setOf("four", "five", "six")
val set8b = mutableSetOf<String>()
for (element in set8) {
    set8b.add(element)
}
for (element in set8a) {
    set8b.add(element)
}
println(set8b.toList())

//Задание 9: Нахождение Пересечения Множеств
//Создайте два множества целых чисел и найдите их пересечение (общие элементы). Реши задачу через вложенные циклы.

//Задание 10: Нахождение Разности Множеств
//Создайте два множества строк и найдите разность первого множества относительно второго (элементы, присутствующие в первом множестве, но отсутствующие во втором). Реши задачу через вложенные циклы и переменные флаги.

//Задание 11: Конвертация Множества в Список
//Создайте множество строк и конвертируйте его в список с использованием цикла.