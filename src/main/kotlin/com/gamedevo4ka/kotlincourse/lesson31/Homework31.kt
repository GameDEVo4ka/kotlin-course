package com.gamedevo4ka.kotlincourse.lesson31

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import java.io.File

fun main() {

    fun createHierarchy(): Employee {
        val techdir = Employee(
            name = "Михаил Смирнов",
            employmentStatus = true,
            dateOfBirth = "1 января 1982",
            position = CharacterTypes.CTO,
            subordinates = listOf(teamLead1, teamLead2)
        )

        val teamLead1 = Employee(
            name = "Виктория Иванова",
            employmentStatus = true,
            dateOfBirth = "10 февраля 1985",
            position = CharacterTypes.TEAM_LEAD,
            subordinates = listOf(designer, developer, tester)
        )

        val teamLead2 = Employee(
            name = "Мария Кузнецова",
            employmentStatus = true,
            dateOfBirth = "20 марта 1990",
            position = CharacterTypes.PM,
            subordinates = listOf(designer, developer, tester)
        )

        val designer = Employee(
            name = "Алиса Морозова",
            employmentStatus = true,
            dateOfBirth = "8 апреля 1993",
            position = CharacterTypes.UX_UI
        )

        val developer = Employee(
            name = "Дмитрий Соколов",
            employmentStatus = true,
            dateOfBirth = "25 мая 1959",
            position = CharacterTypes.BACKEND_DEV
        )

        val tester = Employee(
            name = "Максим Попов",
            employmentStatus = true,
            dateOfBirth = "12 июня 2005",
            position = CharacterTypes.QA
        )
    }

    fun writeToFile(
        employee: Employee,
        fileName: String
    ) {
        val gson: Gson = GsonBuilder().setPrettyPrinting().create()
        val json = gson.toJson(employee)
        val file = File(fileName).writeText(json)
    }
    fun readFromFile(fileName: String): Employee {
        val gson = Gson()
        val json = File(fileName).readText()
        return gson.fromJson(json, Employee::class.java)
    }

    val cto = createHierarchy()
    val fileName = "src/main/kotlin/com/gamedevo4ka/kotlincourse/lesson31/cto.json"
    writeToFile(cto, fileName)
    println("Сериализация CTO")
    val deserializedCTO = readFromFile(fileName)
    println("Дусериализация CTO: $deserializedCTO")
}