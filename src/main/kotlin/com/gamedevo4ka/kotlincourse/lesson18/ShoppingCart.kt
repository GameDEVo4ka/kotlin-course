package com.gamedevo4ka.kotlincourse.lesson18

class Cart {
    private val items = mutableMapOf<String, Int>()

    fun addToCart(itemId: String) {
        items[itemId] = items.getOrDefault(itemId, 0) + 1
    }

    fun addToCart(itemId: String, amount: Int) {
        items[itemId] = items.getOrDefault(itemId, 0) + amount
    }

    fun addToCart(itemsToAdd: Map<String, Int>) {
        for ((itemId, amount) in itemsToAdd) {
            items[itemId] = items.getOrDefault(itemId, 0) + amount
        }
    }

    fun addToCart(itemIds: List<String>) {
        for (itemId in itemIds) {
            items[itemId] = items.getOrDefault(itemId, 0) + 1
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()
        var totalItems = 0
        var totalQuantity = 0
        sb.append("Корзина товаров:\n")
        sb.append("ID товара | Количество товара\n")
        sb.append("--------------------------------------\n")
        for ((itemId, quantity) in items) {
            sb.append("$itemId | $quantity\n")
            totalItems++
            totalQuantity += quantity
        }
        sb.append("--------------------------------------\n")
        sb.append("Количество позиций: $totalItems\n")
        sb.append("Общее количество товаров: $totalQuantity")
        return sb.toString()
    }
}