package com.gamedevo4ka.kotlincourse.lesson20

//1.	Создай абстрактные классы устройств, используя эти интерфейсы. Реализовывать методы не нужно.
//a.	Холодильник
//b.	Стиральная машина
//c.	Умная лампа
//d.	Электронные часы
//e.	Робот-пылесос
//f.	Механические часы
//g.	Фонарик
//h.	Кофемашина
//i.	Умная колонка

abstract class Refrigerator : Powerable, TemperatureRegulatable, Openable
abstract class WashingMachine : Powerable, WaterContainer, WaterConnection, TemperatureRegulatable, Drainable, Programmable
abstract class SmartLamp : Powerable, LightEmitting
abstract class DigitalClock : Powerable, Timable
abstract class RobotVacuum : Powerable, Movable, Cleanable, Programmable, AutomaticShutdown, Rechargeable
abstract class MechanicalClock : Mechanical
abstract class Flashlight : Powerable, LightEmitting, BatteryOperated
abstract class CoffeeMachine : Powerable, WaterContainer, TemperatureRegulatable, Programmable
abstract class SmartSpeaker : Powerable, SoundEmitting, Programmable

//2.	Создай абстрактный класс для включаемого оборудования и имплементируй соответствующий интерфейс с реализацией методов (достаточно println с выполняемым действием).
abstract class PoweredDevice : Powerable {
    override fun powerOn() {
        println("Включение устройства")
    }
    override fun powerOff() {
        println("Выключение устройства")
    }
}

//3.	Создай абстрактный класс для программируемого оборудования (с имплементацией соответствующего интерфейса и реализацией методов) и наследуй его от абстрактного класса включаемого оборудования.
abstract class ProgrammableDevice : PoweredDevice(), Programmable {
    override fun programAction(action: String) {
        println("Программируемое действие: $action")
    }
    override fun execute() {
        println("Выполнение запрограммированного действия")
    }
}

//4.	Создай абстрактный класс оборудования с возможностью устанавливать температуру и открываться и с наследованием от программируемого оборудования. Также имплементируй интерфейсы.
abstract class TemperatureOpenableDevice : ProgrammableDevice(), TemperatureRegulatable, Openable {
    override fun setTemperature(temp: Int) {
        println("Установка температуры на $temp градусов")
    }
    override fun open() {
        println("Открытие устройства")
    }
    override fun close() {
        println("Закрытие устройства")
    }
}

//5.	Создай не абстрактные классы устройств с наследованием от абстрактного класса с возможностью устанавливать температуру и открываться. Пусть это будет холодильник, стиральная машина, чайник, духовка. Добавь недостающие интерфейсы и реализуй необходимые методы (достаточно вывод в консоль производимого действия). Обрати внимание на то, что установка температуры и программирование устройства (считай - задание режима работы) не имеет смысла при выключенном питании - добавь эту проверку.
class Fridge : TemperatureOpenableDevice() {
    override val maxTemperature: Int = 5
    private var isPoweredOn = false
    override fun powerOn() {
        super.powerOn()
        isPoweredOn = true
    }
    override fun powerOff() {
        super.powerOff()
        isPoweredOn = false
    }
    override fun setTemperature(temp: Int) {
        if (isPoweredOn) {
            super.setTemperature(temp)
        } else {
            println("Невозможно установить температуру - устройство выключено")
        }
    }
    override fun programAction(action: String) {
        if (isPoweredOn) {
            super.programAction(action)
        } else {
            println("Невозможно запрограммировать действие - устройство выключено")
        }
    }
    override fun execute() {
        if (isPoweredOn) {
            super.execute()
        } else {
            println("Невозможно выполнить действие - устройство выключено")
        }
    }
}
class WashingMachineImpl : TemperatureOpenableDevice(), WashingMachine {
    override val capacity: Int = 10
    override val maxTemperature: Int = 90

    override fun fillWater(amount: Int) {
        println("Filling water: $amount liters.")
    }
    override fun getWater(amount: Int) {
        println("Getting water: $amount liters.")
    }
    override fun connectToWaterSupply() {
        println("Connecting to water supply.")
    }
    override fun connectToDrain() {
        println("Connecting to drain.")
    }
    override fun drain() {
        println("Draining water.")
    }
}
class Kettle : TemperatureOpenableDevice() {
    override val maxTemperature: Int = 100
}
class Oven : TemperatureOpenableDevice() {
    override val maxTemperature: Int = 250
}


//Интерфейсы для работы
//
//interface Powerable {
//    fun powerOn()
//    fun powerOff()
//}
//
//interface Openable {
//    fun open()
//    fun close()
//}
//
//interface WaterContainer {
//    val capacity: Int
//    fun fillWater(amount: Int)
//    fun getWater(amount: Int)
//}
//
//interface TemperatureRegulatable {
//    val maxTemperature: Int
//    fun setTemperature(temp: Int)
//}
//
//interface WaterConnection {
//    fun connectToWaterSupply()
//    fun getWater(amount: Int)
//}
//
//interface AutomaticShutdown {
//    val sensorType: String
//    val maxSensoredValue: Int
//    fun startMonitoring()
//}
//
//interface Drainable {
//    fun connectToDrain()
//    fun drain()
//}
//
//interface Timable {
//    fun setTimer(time: Int)
//}
//
//interface BatteryOperated {
//    fun getCapacity(): Double
//    fun replaceBattery()
//}
//
//interface Mechanical {
//    fun performMechanicalAction()
//}
//
//interface LightEmitting {
//    fun emitLight()
//    fun completeLiteEmission()
//}
//
//interface SoundEmitting {
//    fun setVolume(volume: Int)
//    fun mute()
//    fun playSound(stream: InputStream)
//}
//
//interface Programmable {
//    fun programAction(action: String)
//    fun execute()
//}
//
//interface Movable {
//    fun move(direction: String, distance: Int)
//}
//
//interface Cleanable {
//    fun clean()
//}
//
//interface Rechargeable {
//    fun getChargeLevel(): Double
//    fun recharge()
//}
//
