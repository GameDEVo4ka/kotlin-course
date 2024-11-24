package com.gamedevo4ka.kotlincourse.lesson24

fun main() {
//Задание 1. Воспроизвести фрагменты кода, которые могут привести к возникновению исключений:
//●	NullPointerException
    val str: String? = null
    println(str!!.length)
//●	ArrayIndexOutOfBoundsException
    val array = arrayOf(1, 2, 3, 4, 5)
    println(array[7])
//●	ClassCastException
    val obj: Any = "String"
    val num = obj as Int
//●	NumberFormatException
    val str = "String"
    val num = str.toInt()
//●	IllegalArgumentException
fun checkAge(age: Int) {
    if (age < 0) {
        throw IllegalArgumentException("Возраст не может иметь отрицательное значение")
    }
}
    checkAge(-1)
//●	IllegalStateException
    val list = listOf<Int>()
    list.iterator().next()
//●	OutOfMemoryError
    val list = mutableListOf<String>()
    while (true) {
        list.add("Ошибка памяти")
    }
//●	StackOverflowError
fun recursiveFunction() {
    recursiveFunction()
}
    recursiveFunction()
//
//Задание 2. Оберни все вызовы из предыдущего задания в блок try-catch и создай для каждого типа ошибки свой catch блок
    try {
        val str: String? = null
        println(str!!.length)
    } catch (e: NullPointerException) {
        println("NullPointerException: ${e.message}")
    }

    try {
        val array = arrayOf(1, 2, 3, 4, 5)
        println(array[7])
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("ArrayIndexOutOfBoundsException: ${e.message}")
    }

    try {
        val obj: Any = "String"
        val num = obj as Int
    } catch (e: ClassCastException) {
        println("ClassCastException: ${e.message}")
    }

    try {
        val str = "String"
        val num = str.toInt()
    } catch (e: NumberFormatException) {
        println("NumberFormatException: ${e.message}")
    }

    try {
        fun checkAge(age: Int) {
            if (age < 0) {
                throw IllegalArgumentException("Возраст не может иметь отрицательное значение")
            }
        }
        checkAge(-1)
    } catch (e: IllegalArgumentException) {
        println("IllegalArgumentException: ${e.message}")
    }

    try {
        val list = listOf<Int>()
        list.iterator().next()
    } catch (e: IllegalStateException) {
        println("IllegalStateException: ${e.message}")
    }

    try {
        val list = mutableListOf<String>()
        while (true) {
            list.add("Ошибка памяти")
        }
    } catch (e: OutOfMemoryError) {
        println("OutOfMemoryError: ${e.message}")
    }

    try {
        fun recursiveFunction() {
            recursiveFunction()
        }
        recursiveFunction()
    } catch (e: StackOverflowError) {
        println("StackOverflowError: ${e.message}")
    }
//
//Задание 3. Оберни все вызовы из предыдущего задания в блок try-catch с одним блоком catch для любого типа исключений. Внутри блока catch, используя when, напиши для каждого исключения вывод в консоль специфического сообщения, подходящего под каждый из типов.
    try {
        val str: String? = null
        println(str!!.length)

        val array = arrayOf(1, 2, 3, 4, 5)
        println(array[7])

        val obj: Any = "String"
        val num = obj as Int

        val strNumber = "String"
        val number = strNumber.toInt()

        fun checkAge(age: Int) {
            if (age < 0) {
                throw IllegalArgumentException("Возраст не может иметь отрицательное значение")
            }
        }
        checkAge(-1)

        val list = listOf<Int>()
        list.iterator().next()

        val memoryList = mutableListOf<String>()
        while (true) {
            memoryList.add("Ошибка памяти")
        }

        fun recursiveFunction() {
            recursiveFunction()
        }
        recursiveFunction()
    } catch (e: Exception) {
        when (e) {
            is NullPointerException -> println("NullPointerException: ${e.message}")
            is ArrayIndexOutOfBoundsException -> println("ArrayIndexOutOfBoundsException: ${e.message}")
            is ClassCastException -> println("ClassCastException: ${e.message}")
            is NumberFormatException -> println("NumberFormatException: ${e.message}")
            is IllegalArgumentException -> println("IllegalArgumentException: ${e.message}")
            is IllegalStateException -> println("IllegalStateException: ${e.message}")
            is OutOfMemoryError -> println("OutOfMemoryError: ${e.message}")
            is StackOverflowError -> println("StackOverflowError: ${e.message}")
            else -> println("Unknown Exception: ${e.message}")
        }
    }
//
//Задание 4. Создай свой тип исключения в отдельном файле, наследуемый от AssertionError и принимающий текст. Выброси это исключение в main
    throw CustomAssertionError("Custom assertion error")
//
//Задание 5. Создай свой тип исключения в отдельном файле, наследуемый от RuntimeException и принимающий ArrayIndexOutOfBoundsException тип в качестве аргумента. Напиши код, который спровоцирует выброс ArrayIndexOutOfBoundsException, перехвати его с помощью try-catch и в блоке catch выведи сообщение в консоль и сделай выброс своего типа исключения.
    try {
        val array = arrayOf(1, 2, 3, 4, 5)
        println(array[7])
    } catch (e: ArrayIndexOutOfBoundsException) {
        println("ArrayIndexOutOfBoundsException: ${e.message}")
        throw CustomRuntimeException(e)
    }
}