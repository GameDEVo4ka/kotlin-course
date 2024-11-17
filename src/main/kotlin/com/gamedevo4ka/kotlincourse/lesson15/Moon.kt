package com.gamedevo4ka.kotlincourse.lesson15

class Moon (var isVisible: Boolean = false, var phase: String = "") {
    fun showPhase() {
        if (!isVisible) {
            println("Луна не видна")
        } else {
            println("Текущая фаза Луны: $phase")
        }
    }
}