package com.gamedevo4ka.kotlincourse.lesson19

fun main() {
    val childrenClass = ChildrenClass(
        "privateVal_1",
        "protectedVal_2",
        "publicVal_3"
    )
    childrenClass.printText()
    childrenClass.publicField = "Антонио Бандерас"
    println(childrenClass.getAll())
}