package com.gamedevo4ka.kotlincourse.lesson22

import com.gamedevo4ka.kotlincourse.lesson22.extensions.pair
import com.gamedevo4ka.kotlincourse.lesson22.extensions.charExt
import com.gamedevo4ka.kotlincourse.lesson22.extensions.mutableListExt
import com.gamedevo4ka.kotlincourse.lesson22.extensions.transformToMap
import com.gamedevo4ka.kotlincourse.lesson22.extensions.toCustomString
import com.gamedevo4ka.kotlincourse.lesson22.extensions.revert
import com.gamedevo4ka.kotlincourse.lesson22.extensions.within
import com.gamedevo4ka.kotlincourse.lesson22.extensions.encrypt
import com.gamedevo4ka.kotlincourse.lesson22.extensions.decrypt
import com.gamedevo4ka.kotlincourse.lesson22.extensions.displayWordWithUsers

fun main() {
//1
//1.a
    val array = IntArray(1, 2, 3, 4, 5)
    val pair = array.pair()
    println(pair)
//1.b
    println('A'.charExt(1, 2, true))
//1.c
    println(mutableListOf(1, 2, 3, 4, 5).mutableListExt(null, 1))
//1.d
    val map: Map<Int, List<String>>? = mapOf(1 to listOf("a", "b", "c"), 2 to listOf("x", "y"))
    val transformedMap = map.transformToMap(1)
    println("$transformedMap")
//1.e
    val longNumber: Long? = 123456789L
    val longString = longNumber.toCustomString()
    println("$longString")
//3
// Целые числа
    val pair1 = Pair(1, 2)
    val reversedPair1 = pair1.revert()
    println("Original: $pair1, Reversed: $reversedPair1")
// Строки
    val pair2 = Pair("hello", "world")
    val reversedPair2 = pair2.revert()
    println("Original: $pair2, Reversed: $reversedPair2")
// С null
    val pair3 = Pair(null, "non-null")
    val reversedPair3 = pair3.revert()
    println("Original: $pair3, Reversed: $reversedPair3")
//5
    var str = "Hello, Kotlin!"
    str = str.encrypt(1)
    println(str)
    println(str.decrypt(1))
//6
    val word = "KOTLIN"
    val users = listOf("Katya", "Oleg", "Tanya", "Leonid", "Ignat", "Natalie")
    word.displayWordWithUsers(users)
}