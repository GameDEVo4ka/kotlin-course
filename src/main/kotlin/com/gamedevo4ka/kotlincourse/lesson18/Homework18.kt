package com.gamedevo4ka.kotlincourse.lesson18

fun main() {
    val animals: List<Animal> = listOf(Dog(), Cat(), Bird())
    for (animal in animals) {
        println(animal.makeSound())
    }

    val shapes = listOf(
        Circle(radius = 10.0),
        Square(side = 15.0),
        Triangle(sideA = 5.0,
            sideB = 10.0,
            angle = 20.0)
    )
    for (shape in shapes) {
        println("Площадь фигуры: ${shape.area()}")
    }

    val laserPrinter = LaserPrinter()
    val inkjetPrinter = InkjetPrinter()
    val longText = "Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст Текст"
    laserPrinter.print(longText)
    println()
    inkjetPrinter.print(longText)

    val cart = Cart()
    cart.addToCart("item1")
    cart.addToCart("item2", 5)
    cart.addToCart(mapOf("item3" to 3, "item4" to 10))
    cart.addToCart(listOf("item5", "item6", "item7", "item1"))
    println(cart)
}