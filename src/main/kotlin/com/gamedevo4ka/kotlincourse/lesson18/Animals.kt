package com.gamedevo4ka.kotlincourse.lesson18

//Задания для отработки переопределения методов
//1.	Животные и Их Звуки
//●	Базовый класс: Animal с методом makeSound().
//●	Классы наследники: Dog, Cat, Bird.
//●	Базовый метод makeSound() в классе Animal выводит "This animal makes no sound."
//●	Переопределите метод makeSound() в каждом классе-наследнике, чтобы Dog выводил "Bark", Cat - "Meow", Bird - "Tweet". Обогати вывод звуков цветом.
//●	Создайте список животных List<Animal> и вызовите в цикле метод makeSound()

open class Animal {
    open fun makeSound(): String = "This animal makes no sound."
}

class Dog : Animal() {
    override fun makeSound(): String = "\u001B[34mBark!\u001B[34m"
}

class Cat : Animal() {
    override fun makeSound(): String = "\u001b[35mMeow!\u001b[0m"
}

class Bird : Animal() {
    override fun makeSound(): String = "\u001b[33mTweet!\u001b[0m"
}

