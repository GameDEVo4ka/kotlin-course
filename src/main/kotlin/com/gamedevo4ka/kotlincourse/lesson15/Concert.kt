package com.gamedevo4ka.kotlincourse.lesson15

class Concert(
    val group: String,
    val place: String,
    val price: Int,
    val capacity: Int
) {
    private var soldTickets: Int = 0
    fun info(){
        println("Концерт группы: '$group', Место проведения: $place, Стоимость билета: $price руб. Вместимость зала: $capacity, Продано: $soldTickets билетов")
    }
    fun buyTicket() {
        if(soldTickets < capacity ) {
            soldTickets++
        } else {
            println("Мест нет!")
        }
    }
}