package com.gamedevo4ka.kotlincourse.lesson15

class Party(val location: String, val attendees: Int) {
    fun details() {
        println("Место проведения: $location, Количество гостей: $attendees")
    }
}