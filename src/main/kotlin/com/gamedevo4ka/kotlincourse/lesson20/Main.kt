package com.gamedevo4ka.kotlincourse.lesson20

fun main() {
    val fridge = Fridge()
    fridge.powerOn()
    fridge.setTemperature(3)
    fridge.open()
    fridge.programAction("Cool down")
    fridge.execute()
    fridge.close()
    fridge.powerOff()

    val washingMachine = WashingMachineImpl()
    washingMachine.powerOn()
    washingMachine.fillWater(5)
    washingMachine.setTemperature(60)
    washingMachine.programAction("Wash clothes")
    washingMachine.execute()
    washingMachine.drain()
    washingMachine.powerOff()

    val kettle = Kettle()
    kettle.powerOn()
    kettle.setTemperature(90)
    kettle.programAction("Boil water")
    kettle.execute()
    kettle.powerOff()

    val oven = Oven()
    oven.powerOn()
    oven.setTemperature(180)
    oven.programAction("Bake bread")
    oven.execute()
    oven.powerOff()
}
