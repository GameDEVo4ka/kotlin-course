package com.gamedevo4ka.kotlincourse.lesson9

fun main() {
    val teacherName: String = "Саша @webrelab"
    val students: List<String> = listOf("@IT_Development", "@alexgalkin1503", "@samikhao", "@Ziuuuuo", "@arskochev", "losewmac", "@avgussst", "@Woke", "@Komik_rock", "@Valentiai", "@akirepko", "@UshArt0", "@DaniilPuris", "@Carbajot", "@FremyUwU", "@misjane", "@Vladkadi", "H!7pD2@z*Nv#4xFt", "@Imecoma", "@Star1ck", "@g2x0n", "@truthdevotion", "@altaeva_al", "@calllmesandy", "@alex_non_hs", "@akadast99", "@emil_emelyanenko", "@nikita_ilbg", "@Mazayovich_ksen", "@CaterinaOdnorog", "@mariasz23", "@TheEvlampiy", "@pav_V_vka", "@syntheticl", "@skazhi_fu", "@H_Dmitriy_I", "@liz_ko", "@grettgerrelet", "@nikitaaltyn", "@Yanka_YoYo", "@martikhor", "@Na_vremya1", "@Ian_grbn", "@salutyao", "@y_abankin", "@KalabinIvan", "@AtUQoLUaE42", "@valekgodov", "@tinhil", "@msflawlessvictory", "@Sushko_L", "@Belafu", "@yaroslava_sosnina", "@V_I85", "@ljnnaa", "@splague", "@ltrfsg", "@kelgorn", "@pavel_likh", "@BlazeeP", "@volha_yemelyanovich", "@artemeva_aa", "@Ekkz17", "@amelekhova")
    val subject: String = "'Автоматизация на Kotlin + Kaspresso для начинающих'"
    val birthdayMessage: String = """
        Дорогой наш $teacherName!
        
 Поздравляем Тебя с Днем Рождения!
 Желаем Тебе крепкого здоровья, счастья, благополучия и успехов во всех делах!
 Пусть каждый день Твоей жизни будет наполнен вдохновением, новыми идеями и интересными проектами!
        
                0   0
                |   |
            ____|___|____
         0  |~ ~ ~ ~ ~ ~|   0
         |  |           |   |
      ___|__|___________|___|__
      |/\/\/\/\/\/\/\/\/\/\/\/|
  0   |       H a p p y       |   0
  |   |/\/\/\/\/\/\/\/\/\/\/\/|   |
 _|___|_______________________|___|__
|/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/\/|
|                                   |
|         B i r t h d a y! ! !      |
| ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ ~ |
|___________________________________|
        
        С уважением,
        Твои ученики 2 потока курса $subject:
    """.trimIndent()

    println(birthdayMessage)

    val studentsList = 10
    for (i in students.indices step studentsList) {
        val group = students.subList(i, kotlin.math.min(i + studentsList, students.size))
        println(group.joinToString(", "))
    }
}