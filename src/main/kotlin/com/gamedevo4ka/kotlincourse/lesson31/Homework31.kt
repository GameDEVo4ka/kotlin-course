package com.gamedevo4ka.kotlincourse.lesson31

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

fun main() {

    val CTO = Employee(
        name = "Михаил Смирнов",
        employmentStatus = true,
        dateOfBirth = "1 января 1982",
        position = CharacterTypes.CTO
    )

    val TEAM_LEAD = Employee(
        name = "Виктория Иванова",
        employmentStatus = true,
        dateOfBirth = "10 февраля 1985",
        position = CharacterTypes.TEAM_LEAD
    )

    val PM = Employee(
        name = "Мария Кузнецова",
        employmentStatus = true,
        dateOfBirth = "20 марта 1990",
        position = CharacterTypes.PM,
    )

    val BACKEND_DEV = Employee(
        name = "Дмитрий Соколов",
        employmentStatus = true,
        dateOfBirth = "25 мая 1959",
        position = CharacterTypes.,
        subordinates = listOf(d)

    val AQA = Employee(
        name = "Алиса Морозова",
        employmentStatus = true,
        dateOfBirth = "75 march 1980",
        position = CharacterTypes.,
        subordinates = listOf()

    )


}