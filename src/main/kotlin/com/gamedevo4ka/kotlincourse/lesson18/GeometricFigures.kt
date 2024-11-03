package com.gamedevo4ka.kotlincourse.lesson18

//Задания для отработки переопределения методов
//2.	Геометрические Фигуры и Их Площадь
//●	Абстрактный (базовый) класс: Shape с open методом area().
//●	Классы наследники: Circle, Square, Triangle.
//●	Метод area() возвращает 0.0.
//●	Переопределите метод area() в каждом классе-наследнике для расчета площади соответствующей фигуры.
//●	Подсказка: каждый класс должен иметь аргументы конструктора, позволяющие вычислить площадь (для круга это радиус, для квадрата это сторона, для треугольника это две стороны и угол между ними)
//●	Создай набор геометрических фигур и выведи в цикле их площадь

abstract class Shape {
    abstract fun area(): Double
}

class Circle(val radius: Double) : Shape() {
    override fun area(): Double = Math.PI * radius * radius
}

class Square(val side: Double) : Shape() {
    override fun area(): Double = side * side
}

class Triangle(val sideA: Double, val sideB: Double, val angle: Double) : Shape() {
    override fun area(): Double = 0.5 * sideA * sideB * Math.sin(Math.toRadians(angle))
}
