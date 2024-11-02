package com.gamedevo4ka.kotlincourse.lesson17

//Задание 2
//Это класс контейнера. Он абстрактный, это означает, что нельзя создавать экземлпяр этого класса, он нужен только для того, чтобы быть основой для подклассов.
//
//Создай подклассы этого контейнера, которые будут добавлять строку material в какое-то определённое место.
//●	Первый класс должен вставлять строку на дно контейнера (должно появиться под индексом 0)
//●	Второй класс должен получать список строк и вставлять их в начало контейнера но поочерёдно с теми данными, которые уже есть. То-есть, наш список должен появиться в контейнере по индексам 0, 2, 4 и так далее.
//●	Третий класс должен добавлять элементы в список в алфавитном порядке. Если мы добавляем новый элемент в список, то он должен встать где-то между другими элементами и занять место в соответствии с сортировкой по алфавиту.
//●	Четвёртый класс должен принимать словарь из строк (ключи и значения). Каждая пара ключа и значения должна попадать в контейнер следующим образом - ключ в начало, значение в конец.
//
//abstract class Materials {
//
//    private val materials = mutableListOf<String>()
//
//    fun addMaterial(material: String) {
//        materials.add(material)
//    }
//
//    fun extractMaterial(): List<String> {
//        val extracted = materials.toList()
//        materials.clear()
//        return extracted
//    }
//
//    fun printContainer() {
//        materials.forEachIndexed { index, layer ->
//            println("[$index]: $layer")
//        }
//    }
//}
//
//Для тестирования можно использовать эту заготовку
//
//val ordinalNumbers = listOf(
//    "first", "second", "third", "fourth", "fifth",
//    "sixth", "seventh", "eighth", "ninth", "tenth",
//    "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth",
//    "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth"
//)

abstract class Materials {
    protected val materials = mutableListOf<String>()
    fun extractMaterial(): List<String> {
        val extracted = materials.toList()
        materials.clear()
        return extracted
    }
    fun printContainer() {
        materials.forEachIndexed { index, layer ->
            println("[$index]: $layer")
        }
    }
    abstract fun addMaterial(material: String)
}

class BottomContainer : Materials() {
    override fun addMaterial(material: String) {
        materials.add(0, material)
    }
}

class InterleaveContainer : Materials() {
    fun addMaterials(materialsList: List<String>) {
        var index = 0
        for (material in materialsList) {
            if (index < materials.size) {
                materials.add(index, material)
            } else {
                materials.add(material)
            }
            index += 2
        }
    }
    override fun addMaterial(material: String) {
        addMaterials(listOf(material))
    }
}

class AlphabeticalContainer : Materials() {
    override fun addMaterial(material: String) {
        materials.add(material)
        materials.sort()
    }
}

class KeyValueContainer : Materials() {
    fun addKeyValuePairs(pairs: Map<String, String>) {
        for ((key, value) in pairs) {
            materials.add(0, key)
            materials.add(value)
        }
    }
    override fun addMaterial(material: String) {
        addKeyValuePairs(mapOf(material to material))
    }
}



val ordinalNumbers = listOf(
    "first", "second", "third", "fourth", "fifth",
    "sixth", "seventh", "eighth", "ninth", "tenth",
    "eleventh", "twelfth", "thirteenth", "fourteenth", "fifteenth",
    "sixteenth", "seventeenth", "eighteenth", "nineteenth", "twentieth"
)

fun main() {
    val bottomContainer = BottomContainer()
    bottomContainer.addMaterial("base")
    bottomContainer.printContainer()

    val interleaveContainer = InterleaveContainer()
    interleaveContainer.addMaterials(ordinalNumbers)
    interleaveContainer.printContainer()

    val alphabeticalContainer = AlphabeticalContainer()
    ordinalNumbers.forEach { alphabeticalContainer.addMaterial(it) }
    alphabeticalContainer.printContainer()

    val keyValueContainer = KeyValueContainer()
    keyValueContainer.addKeyValuePairs(mapOf("one" to "1", "two" to "2", "three" to "3"))
    keyValueContainer.printContainer()
}