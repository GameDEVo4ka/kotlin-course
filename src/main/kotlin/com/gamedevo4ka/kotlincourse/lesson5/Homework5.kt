package com.gamedevo4ka.kotlincourse.lesson5

// Задача 1
//Контекст: Вы изучаете физическое явление затухания звука в помещении. У вас есть измеренное значение начальной интенсивности звука, но из-за ограничений оборудования данные о коэффициенте затухания иногда могут быть неизвестны.
//Задача: Рассчитать предполагаемую интенсивность звука после затухания. Интенсивность звука после затухания пропорциональна начальной интенсивности, умноженной на коэффициент затухания. Если коэффициент затухания неизвестен, использовать стандартное значение 0.5.

fun main() {
    val initialIntensity = 100.0
    val knownAttenuationCoefficient: Double? = 0.3 // Коэффициент затухания известен
    val intensityWithKnownAttenuationCoefficient = printAttenuatedSoungIntensity(initialIntensity, knownAttenuationCoefficient)
    println("Предполагаемая интенсивность звука с известным коэффициентом затухания: $intensityWithKnownAttenuationCoefficient")

    val unknownAttenuationCoefficient: Double? = null // Коэффициент затухания неизвестен
    val intensityWithUnknownAttenuationCoefficient = printAttenuatedSoungIntensity(initialIntensity, unknownAttenuationCoefficient)
    println("Предполагаемая интенсивность звука с неизвестным коэффициентом затухания: $intensityWithUnknownAttenuationCoefficient")

    val cargoValue: Double? = null
    val totalCost = calculateTotalShippingCost(cargoValue) // Полная стоимость доставки
    println("Рассчитываем полную стоимость доставки: $${"%.2f".format(totalCost)}")
    println(calculateTotalShippingCost(300.0))

    printAtmosphericPressure("something")
    printAtmosphericPressure("null")
}
    fun calculateAttenuatedSoundIntensity(initialIntensity: Double, AttenuationCoefficient: Double?): Double {
        val effectiveAttenuationCoefficient = AttenuationCoefficient ?: 0.5
        return initialIntensity * effectiveAttenuationCoefficient
    }



// Задача 2
// Контекст: Клиент оплачивает доставку груза. К стоимости доставки добавляется страховка на груз, которая составляет 0,5% от его стоимости. В случае, если стоимость не указана, то берётся стандартная стоимость в $50
// Задача: Рассчитать полную стоимость доставки.

fun main2() {
    val cargoValue: Double? = null
    val totalCost = calculateTotalShippingCost(cargoValue) // Полная стоимость доставки
    println("Рассчитываем полную стоимость доставки: $${"%.2f".format(totalCost)}")
}

fun calculateTotalShippingCost(cargoValue: Double?): Double {
    val standardCargoValue = cargoValue ?: 50.0
    val insurance = standardCargoValue * 0.05 // Стоимость страховки
    val totalShippingCost = standardCargoValue + insurance // Полная стоимость доставки
    return totalShippingCost
}



// Задача 3
//Контекст: Вы проводите метеорологические измерения. Одним из важных показателей является атмосферное давление, которое должно быть зафиксировано. Лаборант приносит вам набор показателей, но по пути может что-нибудь потерять. Задача - сообщить об ошибке в случае отсутствия показаний атмосферного давления.

fun printAtmosphericPressure(report: String?) {
    println (report ?: throw Exception())
}