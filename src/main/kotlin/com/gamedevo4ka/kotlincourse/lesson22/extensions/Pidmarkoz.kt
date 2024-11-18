package com.gamedevo4ka.kotlincourse.lesson22.extensions

//Задача 6: Собери пидмаркоз!
//
//Многие уже знают любимую игру в Твиттере - собирание разных слов из букв через ответы (но мы то знаем что слово только одно, но не будем его называть). Напиши метод расширения строки, который будет принимать список имён пользователей и выводить в консоли эту строку побуквенно в столбик: имя автора и букву под ним. Если сможешь повторить оригинальный шаблон вывода ответов с помощью похожих ASCII символов, будет очень круто. Вот ссылка на референс:
//https://x.com/SadNSober_/status/1370280031616897026

fun String.displayWordWithUsers(users: List<String>) {
    val maxLength = users.maxOfOrNull { it.length } ?: 0

    // Подготовка строк для вывода
    val userLines = users.map { user ->
        user.padEnd(maxLength, ' ')
    }

    for (i in 0 until length) {
        val char = this[i]

        if (i < userLines.size) {
            // Вывод имени пользователя и соответствующей буквы
            println("${userLines[i]} | $char")
        } else {
            // Если количество пользователей меньше длины строки, выводим только букву
            println(" ".repeat(maxLength) + " | $char")
        }
    }
}