package com.gamedevo4ka.kotlincourse.lesson15

class Emotion(val type: String, val intensity: Int) {
    fun express() {
        when(type.toLowerCase()) {
            "слабая" -> println("Эмоция: $type. Интенсивность: $intensity")
            "средняя" -> println("Эмоция: $type. Интенсивность: $intensity")
            "сильная" -> println("Эмоция: $type. Интенсивность: $intensity")
            else -> println("Неизвестная эмоция.")
        }
    }
}
