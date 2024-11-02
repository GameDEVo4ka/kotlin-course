package com.gamedevo4ka.kotlincourse.lesson17

//Наследования в ООП
//Задание 1
//Потренируйся в создании иерархии классов с расширением базовой сущности.
//Для каждого задания опиши в коде базовый класс с базовыми свойствами и если применимо - методами. Для произвольных классов также добавь особенные свойства. Детально описывать не нужно, упражнение на то, чтобы усвоить иерархию наследования.
//Учебные Заведения
//Базовый класс: Учебное Заведение
//Производные классы: Школа, …
//Дополнительное разветвление для …: …

open class EducationalInstitution(
    val name: String,
    val address: String
)

class School(
    name: String,
    address: String,
    val numberOfStudents: Int
) : EducationalInstitution(name, address)