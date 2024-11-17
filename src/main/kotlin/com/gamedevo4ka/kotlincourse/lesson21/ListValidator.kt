package com.gamedevo4ka.kotlincourse.lesson21

//10.	Создай класс ListValidator
//a.	с дженериком, ограниченным типом Number
//b.	имплементируй интерфейс Validator
//c.	типизированный по типу List с nullable типом дженерика класса
//d.	Реализуй проверку:
//i.	что ни один элемент списка не является null
//ii.	Ни один элемент приведённый к типу Double не равен 0.0

class ListValidator<T: Number> : Validator<List<T?>> {
    override fun check(list: List<T?>): Boolean {
        return !list.contains(null) && list.all { it?.toDouble() != 0.0 }
    }
}