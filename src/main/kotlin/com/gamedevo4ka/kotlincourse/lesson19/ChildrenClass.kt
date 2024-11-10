package com.gamedevo4ka.kotlincourse.lesson19

open class ChildrenClass(
    private val privateVal: String,
    protectedVal: String,
    publicVal: String
) : BaseClass(privateVal, protectedVal, privateVal) {
    private fun privatePrint() {
        println("Печать из класса ChildrenClass")
    }

    override fun verifyPublicField(value: String): Boolean {
        return value == "Антонио Бандерас"
    }

    override var protectedField
        get() = super.protectedField
        set(value) {
            super.protectedField = value
        }

    fun setPrivateField(value: String) {
        this.privateField = value
    }
}