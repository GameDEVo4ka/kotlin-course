package com.gamedevo4ka.kotlincourse.lesson31

import org.junit.jupiter.api.Assertions.*

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class CerealStorageImplTest {

    private val storage = CerealStorageImpl(10f, 20f)

    // Тесты для addCereal
    @Test
    fun `следует выбросить, если емкость контейнера отрицательна`() {
        assertThrows<IllegalArgumentException> {
            CerealStorageImpl(-4f, 10f)
        }
    }

    @Test
    fun `следует выбросить, если storageCapacity меньше, чем containerCapacity`() {
        assertThrows<IllegalArgumentException> {
            CerealStorageImpl(10f, 9.9f)
        }
    }

    @Test
    fun addCereal() = with(storage) {
        addCereal(Cereal.RICE, 2.2f)
        Assertions.assertEquals(2.2f, getAmount(Cereal.RICE))
    }

    @Test
    fun addExtraCereal() = with(storage) {
        addCereal(Cereal.RICE, 2.2f)
        addCereal(Cereal.RICE, 1.3f)
        Assertions.assertEquals(3.5f, getAmount(Cereal.RICE))
    }

    @Test
    fun addMultipleCereal() = with(storage) {
        addCereal(Cereal.RICE, 1.1f)
        addCereal(Cereal.PEAS, 2.7f)
        Assertions.assertAll(
            { Assertions.assertEquals(1.1f, getAmount(Cereal.RICE)) },
            { Assertions.assertEquals(2.7f, getAmount(Cereal.PEAS)) }
        )
    }

    @Test
    fun `должен возвращать 0, если контейнер не полный`() = with(storage) {
        Assertions.assertEquals(0f, addCereal(Cereal.BUCKWHEAT, 9.9f))
    }

    @Test
    fun `следует вернуть остаток, если добавленные крупы больше пустого пространства контейнера`() = with(storage) {
        Assertions.assertEquals(0.1f, addCereal(Cereal.PEAS, 10.1f), 0.01f)
    }

    @Test
    fun `следует выбросить, если количество круп отрицательное`() = with(storage) {
        assertThrows<IllegalArgumentException> {
            addCereal(Cereal.RICE, -1f)
        }
    }

    @Test
    fun `следует выбрасить, когда нет места для нового контейнера`() = with(storage) {
        addCereal(Cereal.RICE, 0.1f)
        addCereal(Cereal.PEAS, 0.1f)
        assertThrows<IllegalStateException> {
            addCereal(Cereal.BUCKWHEAT, 0.1f)
        }
    }

    // Тесты для getCereal
    @Test
    fun `следует вернуть количество взятых круп`() = with(storage) {
        addCereal(Cereal.RICE, 10f)
        Assertions.assertEquals(5f, getCereal(Cereal.RICE, 5f))
        Assertions.assertEquals(5f, getAmount(Cereal.RICE))
    }

    @Test
    fun `следует вернуть имеющееся количество, если запрошено больше, чем доступно`() = with(storage) {
        addCereal(Cereal.RICE, 5f)
        Assertions.assertEquals(5f, getCereal(Cereal.RICE, 10f))
        Assertions.assertEquals(0f, getAmount(Cereal.RICE))
    }

    @Test
    fun `следует выбросить, если количество отрицательное`() = with(storage) {
        assertThrows<IllegalArgumentException> {
            getCereal(Cereal.RICE, -1f)
        }
    }

    // Тесты для removeContainer
    @Test
    fun `следует удалить контейнер, если он пустой`() = with(storage) {
        addCereal(Cereal.RICE, 10f)
        getCereal(Cereal.RICE, 10f)
        Assertions.assertTrue(removeContainer(Cereal.RICE))
    }

    @Test
    fun `не следует удалять контейнер, если он не пустой`() = with(storage) {
        addCereal(Cereal.RICE, 5f)
        Assertions.assertFalse(removeContainer(Cereal.RICE))
    }

    // Тесты для getAmount
    @Test
    fun `должен возвращать правильное количество`() = with(storage) {
        addCereal(Cereal.RICE, 7.5f)
        Assertions.assertEquals(7.5f, getAmount(Cereal.RICE))
    }

    // Тесты для getSpace
    @Test
    fun `должен возвращать правильный объём`() = with(storage) {
        addCereal(Cereal.RICE, 5f)
        Assertions.assertEquals(5f, getSpace(Cereal.RICE))
    }

    // Тесты для toString
    @Test
    fun `должно возвращать правильное строковое представление`() = with(storage) {
        addCereal(Cereal.RICE, 5f)
        val expectedString = "Хранилище с ёмкостью: 20.0, Контейнеры: {RICE=5.0}"
        Assertions.assertEquals(expectedString, toString())
    }
}