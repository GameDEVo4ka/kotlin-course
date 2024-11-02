package com.gamedevo4ka.kotlincourse.lesson17

//Наследования в ООП
//Задание 1
//Потренируйся в создании иерархии классов с расширением базовой сущности.
//Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами. Для произвольных классов также добавь особенные свойства. Детально описывать не нужно, упражнение на то, чтобы усвоить иерархию наследования.
//Геометрические Фигуры
//Базовый класс: Геометрическая Фигура
//Производные классы: Многоугольник, Круг
//Дополнительное разветвление для Многоугольник: Треугольник, Четырехугольник

open class GeometricFigure(
    val name: String
)

open class Polygon(
    name: String,
    val sides: Int
) : GeometricFigure(name)

class Circle(
    name: String,
    val radius: Double
) : GeometricFigure(name)

class Triangle(
    name: String,
    sides: Int,
    val base: Double,
    val height: Double
) : Polygon(name, sides)

class Quadrilateral(
    name: String,
    sides: Int,
    val width: Double,
    val height: Double
) : Polygon(name, sides)
