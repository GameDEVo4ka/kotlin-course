package com.gamedevo4ka.kotlincourse.lesson10

//Работа с массивами Array
//Задание 1: Создание и Инициализация Массива
//Создайте массив из 5 целых чисел и инициализируйте его значениями от 1 до 5.
val array1 = arrayOf(1, 2, 3, 4, 5)

//Задание 2: Создание Пустого Массива
//Создайте пустой массив строк размером 10 элементов.
val array2 = Array(10) { "" }

//Задание 3: Заполнение Массива в Цикле
//Создайте массив из 5 элементов типа Double и заполните его значениями, являющимися удвоенным индексом элемента.
val array3 = DoubleArray(5) { 0.0 }
    for (i in array3.indices) {
    array3[i] = i * 2.0
}
println(array3.ToList())

//Задание 4: Изменение Элементов Массива
//Создайте массив из 5 элементов типа Int. Используйте цикл, чтобы присвоить каждому элементу значение, равное его индексу, умноженному на 3.
val array4 = Array (5) { 0 }
for (i in array4.indices) {
    array4[i] = i * 3
}
println(array4.ToList())

//Задание 5: Работа с Nullable Элементами
//Создайте массив из 3 nullable строк. Инициализируйте его одним null значением и двумя строками.
val array5 = arrayOfNulls<String>(3)
    array5[0] = null
    array5[1] = "Word1"
    array5[2] = "World2"
println(array5.ToList())

//Задание 6: Копирование Массива
//Создайте массив целых чисел и скопируйте его в новый массив в цикле.
val array6 = arrayOf(1, 2, 3, 4, 5)
val array6a = Array(array6.size) { i -> array6[i] }
println(array6a.ToList())

//Задание 7: Разница Двух Массивов
//Создайте два массива целых чисел одинаковой длины. Создайте третий массив, вычев значения одного из другого.
val array7a = arrayOf(10, 20, 30, 40, 50)
val array7b = arrayOf(1, 2, 3, 4, 5)
val array7c = Array(array7a.size) { i -> array7a[i] - array7b[i] }
println(array7c.ToList())

//Задание 8: Поиск Индекса Элемента
//Создайте массив целых чисел. Найдите индекс элемента со значением 5. Если значения 5 нет в массиве, возвращаем -1. Реши задачу через цикл while.
val array8 = arrayOf(1, 2, 3, 4, 5)
var index = -1
var i = 0
    while (i < array8.size) {
        if (array8[i] == 5) {
            index = i
            break
    }
    i++
}
println(index)

//Задание 9: Перебор Массива
//Создайте массив целых чисел. Используйте цикл для перебора массива и вывода каждого элемента в консоль. Напротив каждого элемента должно быть написано “чётное” или “нечётное”.
val array9 = arrayOf(1, 2, 3, 4, 5)
    for (element in array9) {
        val type = if (element % 2 == 0) "чётное" else "нечётное"
println(element - type)
}

//Задание 10: Поиск Значения в Массиве по вхождению
//Создай функцию, которая принимает массив строк и строку для поиска. Функция должна находить в массиве элемент, в котором принятая строка является подстрокой (метод contains()). Верни найденный элемент из функции в виде строки.
val array10 = arrayOf("Kotlin", "is", "fun", "shit")
val array10String = findSubstring(array10, "in")
if (array10String.isNotEmpty()) {
    println(array10String)
} else {
    println()
}

}
fun findSubstring(array10: Array<String>, searchString: String): String {
    for (element in array10) {
        if (element.contains(searchString)) {
            return element
        }
    }
    return ""
}