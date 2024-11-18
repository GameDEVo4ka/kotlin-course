package com.gamedevo4ka.kotlincourse.lesson22.extensions

//Задача 5: Кодер-декодер строк
//Реализуйте для класса String два метода расширения: encrypt и decrypt. Метод encrypt должен сдвигать каждый символ исходной строки на заданное число позиций вперед по таблице Unicode, а метод decrypt — на то же число позиций назад. Оба метода принимают один параметр base типа Int, который определяет величину сдвига. Протестируйте вашу реализацию, убедившись, что после шифрования и последующей расшифровки строка возвращается к исходному состоянию.
//Сдвиг по таблице Unicode реализуется простым прибавлением или вычитанием размера сдвига к char символу.

// Метод расширения encrypt
fun String.encrypt(base: Int): String {
    var res = ""
    for (i in this) {
        res += i + base
    }
    return res
}
// Метод расширения decrypt
fun String.decrypt(base: Int): String {
    var res = ""
    for (i in this) {
        res += i - base
    }
    return res
}