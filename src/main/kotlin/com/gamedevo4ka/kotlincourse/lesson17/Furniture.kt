package com.gamedevo4ka.kotlincourse.lesson17

//Наследования в ООП
//Задание 1
//Потренируйся в создании иерархии классов с расширением базовой сущности.
//Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами. Для произвольных классов также добавь особенные свойства. Детально описывать не нужно, упражнение на то, чтобы усвоить иерархию наследования.
//Иерархия Мебели
//Базовый класс: Мебель
//Производные классы: …
//Дополнительное разветвление для …: …

open class Furniture(
    val material: String,
    val weight: Double)

class Chair(
    material: String,
    weight: Double,
    val numberOfLegs: Int
) : Furniture(material, weight)

class Table(
    material: String,
    weight: Double,
    val shape: String
) : Furniture(material, weight)
