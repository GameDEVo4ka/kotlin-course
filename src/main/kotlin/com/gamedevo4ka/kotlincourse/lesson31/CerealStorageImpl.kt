package com.gamedevo4ka.kotlincourse.lesson31

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
            "Количество добавляемой крупы не может быть отрицательным"
        }
        val currentAmount = storage.getOrDefault(cereal, 0f)
        val spaceLeft = containerCapacity - currentAmount

        if (amount > spaceLeft) {
            if (storage.values.sum() + (amount - spaceLeft) > storageCapacity) {
                throw IllegalStateException("Хранилище переполнено!")
            }
            storage[cereal] = containerCapacity
            return amount - spaceLeft
        } else {
            storage[cereal] = currentAmount + amount
            return 0f
        }
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
    require(amount >= 0) { "Количество забираемой крупы не может быть отрицательным" }

    val currentAmount = storage[cereal] ?: 0f
    return if (currentAmount >= amount) {
        storage[cereal] = currentAmount - amount
        amount
    } else {
        storage[cereal] = 0f
        currentAmount
    }
}

    override fun removeContainer(cereal: Cereal): Boolean {
    val currentAmount = storage[cereal] ?: return false
    return if (currentAmount == 0f) {
        storage.remove(cereal)
        true
    } else {
        false
    }
}

    override fun getAmount(cereal: Cereal): Float {
    return storage[cereal] ?: 0f
}

    override fun getSpace(cereal: Cereal): Float {
    return containerCapacity - (storage[cereal] ?: 0f)
}

    override fun toString(): String {
    return "CerealStorage(containerCapacity=$containerCapacity, storageCapacity=$storageCapacity, storage=$storage)"
}