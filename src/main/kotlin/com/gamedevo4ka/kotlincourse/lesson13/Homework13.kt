package com.gamedevo4ka.kotlincourse.lesson13

fun main() {
    val collection = listOf(1, 2, 3, 4, 5, 6, 7)
    val strings = listOf("One", "Two", "Three", "Four", "Five", "Six", "Seven")
//1. Предварительные задачи на использование методов.
//Подбери подходящий для задачи метод
//Задачи на приведение коллекций к значению
//isNotEmpty
//getOrElse
//joinToString
//firstOrNull
//size
//isEmpty
//minOrNull
//contains
//sum
//average
//maxOrNull
//
//Проверить, что размер коллекции больше 5 элементов.
    println(collection.size > 5)
//Проверить, что коллекция пустая
    println(collection.isEmpty())
//Проверить, что коллекция не пустая
    println(collection.isNotEmpty())
//Взять элемент по индексу или создать значение если индекса не существует
    collection.getOrElse(1) { 8 }
//Собрать коллекцию в строку
    collection.joinToString(separator = ", ")
//Посчитать сумму всех значений
    collection.sum()
//Посчитать среднее
    collection.average()
//Взять максимальное число
    collection.maxOrNull()
//Взять минимальное число
    collection.minOrNull()
//Взять первое число или null
    collection.firstOrNull()
//Проверить что коллекция содержит элемент
    collection.contains(1)
//
//Задачи на обработку коллекций
//sorted
//groupBy
//distinct
//take
//takeLast
//filter
//filterNot
//map
//associate
//sortedDescending
//forEach
//filterNotNull
//
//Отфильтровать коллекцию по диапазону 18-30
    collection.filter { it in 18..30 }
//Выбрать числа, которые не делятся на 2 и 3 одновременно
    collection.filterNot { it % 2 == 0 && it % 3 == 0 }
//Очистить текстовую коллекцию от null элементов
    collection.filterNotNull()
//Преобразовать текстовую коллекцию в коллекцию длин слов
    collection.map { "$it".length }
//Преобразовать текстовую коллекцию в мапу, где ключи - слова, а значения - перевёрнутые слова
    strings.associateWith { it to it.reversed() }
//Отсортировать список в алфавитном порядке
    strings.sorted()
//Отсортировать список по убыванию
    strings.sortedDescending()
//Распечатать квадраты элементов списка
    collection.forEach { println(it * it) }
//Группировать список по первой букве слов
    strings.groupBy { it.first() }
//Очистить список от дублей
    strings.distinct()
//Взять первые 3 элемента списка
    collection.take(3)
//Взять последние 3 элемента списка
    collection.takeLast(3)
//
//Задание 2: Характеристика числовой коллекции
//Написать метод, который принимает коллекцию чисел и возвращает строку с текущим состоянием коллекции используя конструкцию when
//Если коллекция пустая - “Пусто”
//Если количество элементов меньше пяти - “Короткая”
//Если коллекция начинается с 0 - “Стартовая”
//Если сумма всех чисел больше 10000 - “Массивная”
//Если среднее значение равно 10 - “Сбалансированная”
//Если длина строки образованная склеиванием коллекции в строку равна 20 - “Клейкая”
//Если максимальное число меньше -10 - “Отрицательная”
//Если минимальное число больше 1000 - “Положительная”
//Если содержит одновременно числа 3 и 14 - “Пи***тая”
//Иначе - “Уникальная”
//
//Вызвать метод с данными, подходящими под каждую из веток
fun collectionState(collection2: List<Int>): String{
    return when{
        collection2.isEmpty() -> "Пусто"
        collection2.size < 5 -> "Короткая"
        collection2.getOrNull(0) == 0 -> "Стартовая"
        collection2.sum() >= 10000 -> "Массивная"
        collection2.average().toInt() == 10 -> "Сбалансированная"
        collection2.joinToString("").length ==  20 -> "Клейкая"
        collection2.max() < - 10 -> "Отрицательная"
        collection2.min() > 1000 -> "Положительная"
        collection2.contains(3) && collection2.contains(14) -> "Пи***тая"
        else -> "Уникальная"
    }
}
    val emptyCollection = listOf<Int>()
    println(collectionState(emptyCollection))
    val shortCollection = listOf(1, 2, 3, 4)
    println(collectionState(shortCollection))
    val startCollection = listOf(0, 2, 4, 6, 8)
    println(collectionState(startCollection))
    val massiveCollection = listOf(5000, 3000, 2001)
    println(collectionState(massiveCollection))
    val balancedCollection = listOf(10, 10, 10, 10, 10)
    println(collectionState(balancedCollection))
    val stickyCollection = listOf(1, 2, 3, 4, 5, 6, 7, 8)
    println(collectionState(stickyCollection))
    val negativeCollection = listOf(-15, -20, -30)
    println(collectionState(negativeCollection))
    val positiveCollection = listOf(1001, 2000, 3000)
    println(collectionState(positiveCollection))
    val piCollection = listOf(3, 14, 9, 2)
    println(collectionState(piCollection))
    val uniqueCollection = listOf(99, 75, 88)
    println(collectionState(uniqueCollection))
//
//Задание 3: Анализ Учебных Оценок
//Начальные значения: val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
//Цель: Отфильтровать удовлетворительные оценки (>=60), отсортировать оставшиеся по возрастанию и взять первые 3.
    val grades = listOf(85, 58, 90, 74, 88, 67, 95, 92, 50, 42, 12)
    val result = grades.filter { it >= 60 }
        .sorted()
        .take(3)
    println(result)
//
//Задание 4: Создание каталога по первой букве.
//Начальные значения: val list = listOf(
//    "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
//)
//Цель: Привести все слова в списке к нижнему регистру, сгруппировать в каталог по первой букве.
    val list = listOf(
        "Стол", "табурет", "ваза", "Кружка", "Зеркало", "ковер", "Шкаф", "часы", "Люстра", "подушка", "Картина", "столик", "Вазон", "шторы", "Пуф", "книга", "Фоторамка", "светильник", "Коврик", "вешалка", "Подставка", "телевизор", "Комод", "полка", "Абажур", "диван", "Кресло", "занавеска", "Бра", "пепельница", "Глобус", "статуэтка", "Поднос", "фигурка", "Ключница", "плед", "Тумба", "игрушка", "Настенные часы", "подсвечник", "Журнальный столик", "сувенир", "Корзина для белья", "посуда", "Настольная лампа", "торшер", "Этажерка"
    )
    println(list.map { it.lowercase() }
        .groupBy { it[0] }
    )
//
//Задание 5: Подсчёт средней длины слов в списке.
//Начальные значения из задачи 3.
//Цель: Перевести все слова в количество букв, подсчитать среднее значение. Вывести форматированный текст с двумя знаками после запятой.
    println("%.2f".format(list.map { it.length }.average()))
//
//Задание 6: Категоризация чисел.
//Начальные значения: val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
//Цель: Отобрать уникальные числа, отсортировать по убыванию и сгруппировать по четности (“четные” и “нечетные”).
    val numbers = listOf(1, 3, 5, 7, 3, 1, 8, 9, 9, 7)
    println(((numbers.distinct()).sortedDescending()).groupBy {
        if (it % 2 == 0) "четные" else "нечетные" })
//
//Задание 7: Поиск первого подходящего элемента
//Начальные значения: val ages = listOf(22, 18, 30, 45, 17, null, 60)
//Цель: Найти первый возраст в списке, который соответствует условию (больше 18), преобразовать его к строке, или вернуть сообщение "Подходящий возраст не найден".
    val ages = listOf(22, 18, 30, 45, 17, null, 60)
    println(ages.filterNotNull().firstOrNull{ it > 18 }?.toString() ?: "Подходящий возраст не найден")
}