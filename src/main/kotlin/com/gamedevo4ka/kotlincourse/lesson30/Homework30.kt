package com.gamedevo4ka.kotlincourse.lesson30

//Задание 1
//Создай Enum со статусами прохождения теста (pass, broken, failure).

enum class TestStatuses() {
    PASS,
    BROKEN,
    FAILURE,
    ;
}

//Создай Enum с типами жилой недвижимости для сайта аренды, включая человекопонятные названия этих типов.

enum class RealEstateTypes (val humanReadable: String) {
    APARTMENT ("Квартира"),
    COMMUNAL_APARTMENT ("Коммунальная квартира"),
    HOUSE ("Дом"),
    COTTAGE ("Коттедж"),
    VILLA ("Вилла"),
    ;
}

//Создай Enum с планетами солнечной системы, включая расстояние до солнца в астрономических единицах и вес планеты.

enum class SolarSystemPlanets(val distanceToSunAU: Double, val massKg: Double) {
    MERCURY (0.387, 0.330e24),
    VENUS (0.723, 4.87e24),
    EARTH (1.0, 5.97e24),
    MARS (1.524, 0.642e24),
    JUPITER (5.203, 1898e24),
    SATURN (9.582, 568e24),
    URANUS (19.218, 86.8e24),
    NEPTUNE (30.070, 102e24),
    ;
}

//Задание 2
//Создай функцию, которая выводит на печать человекочитаемые названия типов недвижимости в порядке возрастания длины названия enum.

fun reaEstateAscending() {
    RealEstateTypes.entries
        .sortedBy { it.name.length }
        .forEach { println(it.humanReadable) }
}

//Задание 3
//Создай функцию, которая принимает лямбду без аргументов и возвращаемого значения и возвращает Enum со статусом прохождения теста в зависимости от того как выполнится принятая лямбда. Если без исключений - pass, если будет AssertionError - failure, прочие исключения  - broken.

fun testResult(test: () -> Unit): TestStatuses {
    return try {
        test()
        TestStatuses.PASS
    } catch (e: AssertionError) {
        TestStatuses.FAILURE
    } catch (e: Exception) {
        TestStatuses.BROKEN
    }
}

//Задание 4
//Создай функцию, которая принимает лямбду и возвращает enum планеты. Лямбда должна принимать планету и возвращать булево значение. Лямбда здесь выступает в качестве фильтра, который должен отфильтровать список всех планет по какому-либо признаку (расстояние или вес). Вернуть нужно первый элемент из отфильтрованного списка или выкинуть исключение если список пустой.
//
//
fun filterPlanets(planet: (SolarSystemPlanets) -> Boolean): SolarSystemPlanets {
    return SolarSystemPlanets.entries.firstOrNull(planet)
        ?: throw NoSuchElementException("Планета не найдена")
}


fun main() {
    reaEstateAscending()

    val status1 = testResult {
        println("Тест запущен")
    }
    println("Статус теста: $status1")

    val status2 = testResult{
        assert(false) { "Тест не пройден!" }
    }
    println("Статус теста: $status2")

    val status3 = testResult {
        throw RuntimeException("Произошла непредвиденная ошибка")
    }
    println("Статус теста: $status3")



    val remotePlanet = filterPlanets { it.distanceToSunAU > 5 }
    println("Дальше 5 а.е. от Солнца находится - $remotePlanet")

    val heavyPlanet = filterPlanets { it.massKg > 5.97e24}
    println("Весит больше 5.97e24 - $heavyPlanet")

    val exception = filterPlanets { it.massKg < 1e24 && it.distanceToSunAU > 1.0}
}