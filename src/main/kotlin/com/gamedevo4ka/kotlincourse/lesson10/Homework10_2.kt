package com.gamedevo4ka.kotlincourse.lesson10

//Работа со списками List
//Задание 1: Создание Пустого Списка
//Создайте пустой неизменяемый список целых чисел.
val list1 = listOf<Int>()

//Задание 2: Создание и Инициализация Списка
//Создайте неизменяемый список строк, содержащий три элемента (например, "Hello", "World", "Kotlin").
val list2 = listOf("Hello", "World", "Kotlin")

//Задание 3: Создание Изменяемого Списка
//Создайте изменяемый список целых чисел и инициализируйте его значениями от 1 до 5.
val list3 = mutableListOf(1, 2, 3, 4, 5)

//Задание 4: Добавление Элементов в Список
//Имея изменяемый список целых чисел, добавьте в него новые элементы (например, 6, 7, 8).
val list4 = mutableListOf(1, 2, 3, 4, 5)
    list4.add(6)
    list4.add(7)
    list4.add(8)
println(list4.ToList())

//Задание 5: Удаление Элементов из Списка
//Имея изменяемый список строк, удалите из него определенный элемент (например, "World").
val list5 = mutableListOf("Hello", "World", "Kotlin")
    list5.remove("World")
println(list5.toList())

//Задание 6: Перебор Списка в Цикле
//Создайте список целых чисел и используйте цикл для вывода каждого элемента на экран.
val list6 = listOf(1, 2, 3, 4, 5)
    for (element in list6) {
println(element)
}

//Задание 7: Получение Элементов Списка по Индексу
//Создайте список строк и получите из него второй элемент, используя его индекс.
val list7 = listOf("Hello", "World", "Kotlin")
val secondElement = list7[1]

//Задание 8: Перезапись Элементов Списка по Индексу
//Имея изменяемый список чисел, измените значение элемента на определенной позиции (например, замените элемент на позиции 2 на новое значение).
val list8 = mutableListOf(1, 2, 3, 4, 5)
mutableList8[2] = 10

//Задание 9: Объединение Двух Списков
//Создайте два списка строк и объедините их в один новый список, содержащий элементы обоих списков. Реши задачу с помощью циклов.
val list1 = listOf("One", "Two", "Three")
val list2 = listOf("Four", "Five", "Six")
val combinedList = mutableListOf<String>()
    for (element in list1) {
    combinedList.add(element)
}
    for (element in list2) {
    combinedList.add(element)
}

//Задание 10: Нахождение Минимального/Максимального Элемента
//Создайте список целых чисел и найдите в нем минимальный и максимальный элементы используя цикл.
val numbers = listOf(5, 1, 9, 2, 7)
var min = numbers[0]
var max = numbers[0]
for (number in numbers) {
    if (number < min) {
        min = number
        }
    if (number > max) {
        max = number
}
}
println(min)
println(max)

//Задание 11: Фильтрация Списка
//Имея список целых чисел, создайте новый список, содержащий только четные числа из исходного списка используя цикл.
val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
val newNumbers = mutableListOf<Int>()
    for (number in numbers) {
    if (number % 2 == 0) {
        newNumbers.add(number)
    }
}
println(newNumbers)