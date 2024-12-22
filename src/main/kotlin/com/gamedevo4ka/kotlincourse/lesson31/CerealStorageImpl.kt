package com.gamedevo4ka.kotlincourse.lesson31

import kotlin.math.min

class CerealStorageImpl(
    override val containerCapacity: Float,
    override val storageCapacity: Float
) : CerealStorage {

    init {
        require(containerCapacity >= 0) {
            "Ёмкость контейнера не может быть отрицательной"
        }
        require(storageCapacity >= containerCapacity) {
            "Ёмкость хранилища не должна быть меньше ёмкости одного контейнера"
        }
    }

    private val storage = mutableMapOf<Cereal, Float>()


    override fun addCereal(cereal: Cereal, amount: Float): Float {
        require(amount >= 0) {
            "Количество крупы не может быть отрицательным"
        }
        checkStorageCapacity(cereal)
        val currentAmount = storage.getOrDefault(cereal, 0f)
        val amountForAdding = min(getSpace(cereal), amount)
        storage[cereal] = currentAmount + amountForAdding
        return amount - amountForAdding
    }

    override fun getCereal(cereal: Cereal, amount: Float): Float {
        TODO()
    }

    override fun removeContainer(cereal: Cereal): Boolean {
        TODO()
    }

    override fun getAmount(cereal: Cereal): Float {
        return storage.getOrDefault(cereal, 0f)
    }

    override fun getSpace(cereal: Cereal): Float {
        return containerCapacity - getAmount(cereal)
    }

    override fun toString(): String {
        TODO()
    }

    private fun checkStorageCapacity(cereal: Cereal) {
        if (storage.contains(cereal)) return
        check(storageCapacity >= (storage.size + 1) * containerCapacity) {
            "Недостаточно места в хранилище для нового контейнера"
        }
    }
}



    override fun getCereal(cereal: Cereal, amount: Float): Float {
    require(amount >= 0) {
        "Количество крупы не может быть отрицательным"
    }
    val currentAmount = storage.getOrDefault(cereal, 0f)
    val amountToTake = min(currentAmount, amount)
    storage[cereal] = currentAmount - amountToTake
    return amountToTake
}

    override fun removeContainer(cereal: Cereal): Boolean {
    val currentAmount = storage.getOrDefault(cereal, 0f)
    return if (currentAmount == 0f) {
        storage.remove(cereal)
        true
    } else {
        false
    }
}

    override fun toString(): String {
    return "Хранилище с ёмкостью: $storageCapacity, Контейнеры: $storage"
}

