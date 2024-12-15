package com.gamedevo4ka.kotlincourse.lesson29

import java.time.*
import java.time.format.DateTimeFormatter
import java.time.temporal.Temporal

fun main() {

//1.	Создай текущую временнУю метку и выведи её на печать (чтобы ещё раз запомнить название этого класса)

    val currentTime = Instant.now()
    println(currentTime)

//2.	Создай дату своего дня рождения.

    val myBirthday = LocalDate.of(1900,1, 1)
    println(myBirthday)

//3.	Создай период между датой своего рождения и текущей датой. Выведи на печать количество лет из этого периода.

    val currentDate = LocalDate.now()
    val nowPeriod = Period.between(currentDate, myBirthday)
    println(nowPeriod)

//4.	Создай функцию, которая принимает тип Temporal и выводит форматированное значение в зависимости от того, содержит ли аргумент время и часовой пояс. Temporal - это общий тип для разных классов даты-времени. В форматированном значении нужно выводить часы, минуты, секунды и таймзону, если они представлены в переданном объекте. Обработай в методе все типы дат, которые знаешь. Реализуй два варианта функции - с собственный форматированием и с форматами из ISO коллекции.

    fun formatAnyDate(temporal: Temporal) {
        val formattedDate = when (temporal) {
            is LocalDate -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))
            is LocalTime -> temporal.format(DateTimeFormatter.ofPattern("HH:mm:ss"))
            is LocalDateTime -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
            is ZonedDateTime -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZ"))
            is OffsetDateTime -> temporal.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss ZZZ"))
            else -> temporal.toString()
        }
        println(formattedDate)
    }


    fun formatAnyDateByIso(temporal: Temporal) {
        val formattedDate = when (temporal) {
            is LocalDate -> temporal.format(DateTimeFormatter.ISO_LOCAL_DATE)
            is LocalTime -> temporal.format(DateTimeFormatter.ISO_TIME)
            is LocalDateTime -> temporal.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME)
            is ZonedDateTime -> temporal.format(DateTimeFormatter.ISO_ZONED_DATE_TIME)
            is OffsetDateTime -> temporal.format(DateTimeFormatter.ISO_OFFSET_DATE_TIME)
            else -> temporal.toString()
        }
        println(formattedDate)
    }

//5.	Создай объекты дат и / или времени которые мы изучили и по очереди передай их в метод созданный выше. Не используй в них метод now()

        val localDate = LocalDate.of(2023, 2, 25)
        val localTime = LocalTime.of(14, 30, 45)
        val localDateTime = LocalDateTime.of(2023, 2, 25, 14, 30, 45)
        val zonedDateTime = ZonedDateTime.of(localDateTime, ZoneId.of("UTC+3"))
        val offsetDateTime = OffsetDateTime.of(localDateTime, ZoneOffset.ofHours(3))

        formatAnyDate(localDate)
        formatAnyDate(localTime)
        formatAnyDate(localDateTime)
        formatAnyDate(zonedDateTime)
        formatAnyDate(offsetDateTime)

        formatAnyDateByIso(localDate)
        formatAnyDateByIso(localTime)
        formatAnyDateByIso(localDateTime)
        formatAnyDateByIso(zonedDateTime)
        formatAnyDateByIso(offsetDateTime)

//6.	Создайте функцию identifyGeneration, которая принимает дату рождения в формате LocalDate и печатает строку, определяющую, к какому поколению принадлежит человек: "Бумер" для тех, кто родился с 1946 по 1964 год включительно, и "Зумер" для тех, кто родился с 1997 по 2012 год включительно. Если дата рождения не попадает ни в один из этих диапазонов, функция должна возвращать "Не определено". Для сравнения дат используй методы isAfter(otherDate) и isBefore(otherDate). Объекты с эталонными датами вынеси в приватные поля файла с методом identifyGeneration.

    private val boomerFromDate = LocalDate.of(1946, 1, 1)
    private val boomerEndDate = LocalDate.of(1964, 12, 31)
    private val zoomerStartDate = LocalDate.of(1997, 1, 1)
    private val zoomerEndDate = LocalDate.of(2012, 12, 31)

    fun identifyGeneration(date: LocalDate): String {
        return when {
            date.isAfter(boomerFromDate) && date.isBefore(boomerEndDate.plusDays(1)) -> "Бумер"
            date.isAfter(zoomerStartDate) && date.isBefore(zoomerEndDate.plusDays(1)) -> "Зумер"
            else -> "Не определено"
        }
    }

        val birthDate1 = LocalDate.of(1950, 6, 15)
        val birthDate2 = LocalDate.of(2000, 9, 21)
        val birthDate3 = LocalDate.of(1985, 4, 11)

        println("Generation for $birthDate1: ${identifyGeneration(birthDate1)}")
        println("Generation for $birthDate2: ${identifyGeneration(birthDate2)}")
        println("Generation for $birthDate3: ${identifyGeneration(birthDate3)}")

//7.	Создай два объекта даты: 25 февраля 2023 года и 25 февраля 2024 года. Создай форматтер, который форматирует дату в месяц и день.
//Выведи первую отформатированную дату, прибавив к ней 10 дней.
//Выведи вторую отформатированную дату, прибавив к ней 10 дней.
//Найди отличия

        val date1 = LocalDate.of(2023, 2, 25)
        val date2 = LocalDate.of(2024, 2, 25)

        val formatter = DateTimeFormatter.ofPattern("MMMM dd")

        val date1Plus10Days = date1.plusDays(10)
        val date2Plus10Days = date2.plusDays(10)

        println("Formatted date1 + 10 days: ${date1Plus10Days.format(formatter)}")
        println("Formatted date2 + 10 days: ${date2Plus10Days.format(formatter)}")

}