package com.gamedevo4ka.kotlincourse.lesson26

//Задания на отработку синтаксиса
//Напишите функцию, которая принимает другую функцию без аргументов и возвращаемого значения.
fun acceptFunction(fn: () -> Unit) {}

//Создайте функцию, принимающую функцию с одним аргументом типа Int и возвращающую String.
fun acceptIntAndReturnString(fn: (Int) -> String) {}

//Реализуйте функцию, принимающую функцию расширения типа Int, принимающую String и возвращающую Boolean.
fun acceptIntExtension(fn: Int.(String) -> Boolean) {}

//Напишите функцию, которая принимает функцию с двумя аргументами типа Double и возвращает Boolean.
fun acceptDoubleFunction(fn: (Double, Double) -> Boolean) {}

//Напишите функцию, которая принимает функцию с одним аргументом-дженериком T и возвращает List<T>.
fun <T> acceptGenericFunction(fn: (T) -> List<T>) {}

//Создайте функцию, принимающую функцию с аргументом типа String и возвращающую другую функцию, принимающую Int и возвращающую Boolean.
fun acceptAndReturnFunction(fn: (String) -> ((Int) -> Boolean)) {}

//Напишите функцию, которая принимает список чисел, множество строк, функцию с аргументами типа List<Int> и Set<String> и возвращающую Map<String, Int>.
fun funMap(
    numbers: List<Int>,
    strings: Set<String>,
    fn: (List<Int>, Set<String>) -> Map<String, Int>) {}

//Напишите функцию, возвращающую строку, принимающую число и функцию, принимающую число и возвращающую строку
fun acceptAndReturnStringFromFunction(number: Int, fn: (Int) -> String): String {
    return fn(number)
}

//Напишите функцию, принимающую функцию, которая возвращает функцию без аргументов и возвращаемого значения.
fun acceptReturningFunction(fn: () -> () -> Unit) {}

//
//
//Задания на разработку кода
//Напишите функцию filterStrings, которая принимает список строк и функцию-фильтр, оставляющую только строки, удовлетворяющие условию (то-есть принимающая строку и возвращающая булево значение). Функция должна вернуть результат фильтрации исходного списка строк.
fun filterStrings(
    listStr: List<String>,
    filterFun: (String) -> Boolean,
): List<String> {
    return listStr.filter(filterFun)
}

val filterByLength: (String) -> Boolean = { it.length > 3 }
val filterByPrefix: (String) -> Boolean = { it.startsWith("a") }

//Создайте функцию applyToNumbers, которая принимает список чисел и функцию, преобразующую каждое число в другое число (те-есть принимающая число и возвращающая число). Функция должна вернуть результат преобразования исходного списка чисел.
fun applyToNumbers(
    numList: List<Number>,
    transformFun: (Number) -> Number
): List<Number> {
    return numList.map(transformFun)
}

val doubleNumber: (Int) -> Int = { it * 2 }
val squareNumber: (Int) -> Int = { it * it }

//Реализуйте функцию sumByCondition, которая принимает список чисел и функцию, определяющую условие для включения числа в сумму. Функция должна вернуть сумму чисел, прошедших проверку.
fun sumByCondition(
    numList: List<Int>,
    checkFun: (Int) -> Boolean
): Int {
    return numList.filter(checkFun).sum()
}

val isEven: (Int) -> Boolean = { it % 2 == 0 }
val isPositive: (Int) -> Boolean = { it > 0 }
val isNegative: (Int) -> Boolean = { it < 0 }

//Напишите функцию combineAndTransform, которая принимает две коллекции одного типа и функцию для их объединения и преобразования в одну коллекцию другого типа. Функция должна вернуть результат преобразования (коллекцию второго типа)
fun <T> combineAndTransform(
    collection1: List<T>,
    collection2: List<T>,
    funUnion: (List<T>, List<T>) -> Set<T>
): Set<T> {
    return funUnion(collection1, collection2)
}

fun <T, K> combineAndTransform1(
    collection1: List<T>,
    collection2: List<T>,
    funUnion: (List<T>, List<T>) -> List<K>
): List<K> {
    return funUnion(collection1, collection2)
}

fun <T,K,L: Collection<T>,M: Collection<K>> combineAndTransform2(
    collection1: L,
    collection2: L,
    funUnion: (L,L) -> M
): M {
    val sum = collection1 + collection2
    return funUnion(collection1,collection2)
}

val concatAndToString: (Collection<Int>, Collection<Int>) -> Collection<String> = { col1, col2 ->
    (col1 + col2).map { it.toString() }
}
val combineAndSum: (Collection<Int>, Collection<Int>) -> Collection<Int> = { col1, col2 ->
    listOf((col1 + col2).sum())
}
val combineAndAverage: (Collection<Int>, Collection<Int>) -> Collection<Double> = { col1, col2 ->
    listOf((col1 + col2).average())
}

//
//⚡ Для последних четырёх заданий сделать минимум по две разные реализации лямбда функций и проверить работу на разных наборах данных

fun main() {
    val strings = listOf("один", "два", "три", "четыре")
    println(filterStrings(strings, filterByLength))
    println(filterStrings(strings, filterByPrefix))



    val numbers1 = listOf(1, 2, 3, 4, 5)
    val numbers2 = listOf(-1, -2, -3, -4, -5)

    val result1 = applyToNumbers(numbers1, doubleNumber)
    val result2 = applyToNumbers(numbers1, squareNumber)
    val result3 = applyToNumbers(numbers2, doubleNumber)
    val result4 = applyToNumbers(numbers2, squareNumber)
    println(result1)
    println(result2)
    println(result3)
    println(result4)



    val numbers3 = listOf(-3, 2, -1, 4, -5, 6)
    val numbers4 = listOf(0, 1, 2, 3, 4, 5)

    val result5 = sumByCondition(numbers1, isEven)
    val result6 = sumByCondition(numbers1, isPositive)
    val result7 = sumByCondition(numbers1, isNegative)
    val result8 = sumByCondition(numbers2, isEven)

    println(result5)
    println(result6)
    println(result7)
    println(result8)



    val collection1 = listOf(1, 2, 3)
    val collection2 = listOf(4, 5, 6)

    val result9 = combineAndTransform(collection1, collection2, concatAndToString)
    val result10 = combineAndTransform(collection1, collection2, combineAndSum)
    val result11 = combineAndTransform(collection1, collection2, combineAndAverage)

        println(result9)
        println(result10)
        println(result11)

}

