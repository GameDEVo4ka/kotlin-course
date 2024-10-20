package com.gamedevo4ka.kotlincourse.lesson14

//Для решения каждой задачи постарайтесь использовать наиболее подходящий метод, не повторяясь с решением других задач.
fun main() {
//
//Дан словарь с именем и временем выполнения каждого автоматизированного теста в секундах. Определите среднее время выполнения теста.
    val testTimes = mapOf("Test1" to 200, "Test2" to 300, "Test3" to 100)
    val averageTime = testTimes.values.average()
    println("$averageTime")
//
//Имеется словарь с метаданными автоматизированных тестов, где ключи — это имена тестовых методов а значения - строка с метаданными. Выведите список всех тестовых методов.
    val metaData = mapOf("testMethod1" to "metaData1", "testMethod2" to "metaData2")
    val testMethods = metaData.keys.toList()
    println("$testMethods")
//
//В изменяемый словарь с данными о прохождении тестов добавьте новый тест и его результат.
    val testResult = mutableMapOf("Test1" to "Passed", "Test2" to "Failed")
    testResult["Test3"] = "Passed"
    println("$testResult")
//
//Посчитайте количество успешных тестов в словаре с результатами.
    val testResult2 = mapOf("Test1" to "Passed", "Test2" to "Failed", "Test3" to "Passed")
    val successfulTests = testResult2.values.count { it == "Passed" }
    println("$successfulTests")
//
//Удалите из изменяемого словаря с баг-трекингом запись о баге, который был исправлен.
    val bugTracker = mutableMapOf("Bug1" to "Open", "Bug2" to "In work", "Bug3" to "Fixed")
    bugTracker.remove("Bug3")
    println("$bugTracker")
//
//Для словаря с результатами тестирования веб-страниц (ключ — URL страницы, значение — статус ответа), выведите сообщение о странице и статусе её проверки.
    val pageStatus = mapOf("Page1" to "200 OK", "Page2" to "500 Internal Server Error", "Page3" to "404 Not Found")
    pageStatus.forEach { (url, status) -> println("$url, $status") }
//
//Найдите в словаре с названием и временем ответа сервисов только те, время ответа которых превышает заданный порог.
    val responseTime = mapOf("Service1" to 100, "Service2" to 50, "Service2" to 30)
    val threshold = 75
    val exceedService = responseTime.filter { it.value > threshold }
    println("$exceedService")
//
//В словаре хранятся результаты тестирования API (ключ — endpoint, значение — статус ответа в строке). Для указанного endpoint найдите статус ответа, если endpoint отсутствует, предположите, что он не был протестирован.
    val apiResult = mapOf("Endpoint1" to "200 OK", "Endpoint2" to "304 Not Modified")
    val endpoint = "Endpoint3"
    val status = apiResult.getOrElse(endpoint) { "Не был протестирован" }
    println("$endpoint: $status")
//
//Из словаря, содержащего конфигурации тестового окружения (ключ — название параметра конфигурации), получите значение для "browserType". Ответ не может быть null.
    val testConfig = mapOf("browserType" to "Chrome", "version" to "1.5")
    val browserType = testConfig["browserType"] ?: error("Ответ не может быть null")
    println("$browserType")
//
//Создайте копию неизменяемого словаря с данными о версиях тестируемого ПО, чтобы добавить новую версию.
    val version = mapOf("1" to "Stable", "1.2" to "Beta")
    val newVersion = version.toMutableMap()
    newVersion["1.3"] = "Canary"
    println("$newVersion")
//
//Используя словарь с настройками тестирования для различных мобильных устройств (ключ — модель устройства), получите настройки для конкретной модели или верните настройки по умолчанию.
    val deviceSettings = mapOf("Device1" to "Settings1", "Device2" to "Settings2")
    val model = "Device3"
    val settings = deviceSettings.getOrDefault(model, "DefaultSettings")
    println("$model: $settings")
//
//Проверьте, содержит ли словарь с ошибками тестирования (код и описание) определенный код ошибки.
    val errorCode = mapOf("404" to "Not Found", "304" to "Not Modified", "500" to "Internal Server Error")
    val code = "404"
    val containsCode = errorCode.containsKey(code)
    println("$code: $containsCode")
//
//Дан неизменяемый словарь, где ключи — это идентификаторы тестовых сценариев в формате "TestID_Version", а значения — статусы выполнения этих тестов ("Passed", "Failed", "Skipped"). Отфильтруйте словарь, оставив только те сценарии, идентификаторы которых соответствуют определённой версии тестов.
    val testScenarios = mapOf("Test1" to "Passed", "Test2" to "Failed", "Test3" to "Skipped")
    val ver = "1.0"
    val filteredScenarios = testScenarios.filterKeys { it.endsWith("_$ver") }
    println("$filteredScenarios")
//
//У вас есть словарь, где ключи — это названия функциональных модулей приложения, а значения — результаты их тестирования. Проверьте, есть ли модули с неудачным тестированием.
    val moduleResult = mapOf("Module1" to "Passed", "Module2" to "Failed")
    val failures = moduleResult.values.any { it == "Failed" }
    println("$failures")
//
//Добавьте в изменяемый словарь с настройками тестовой среды настройки из другого словаря.
    val testEnvSettings = mutableMapOf("setting1" to "value1", "setting2" to "value2")
    val newSettings = mapOf("setting3" to "value3")
    testEnvSettings.putAll(newSettings)
    println("$testEnvSettings")
//
//Объедините два неизменяемых словаря с данными о багах.
//
//Очистите изменяемый словарь с временными данными о последнем прогоне автоматизированных тестов.
//
//Исключите из отчета по автоматизированному тестированию те случаи, где тесты были пропущены (имеют статус “skipped”)
//
//Удалите из словаря с конфигурациями тестирования набор устаревших конфигураций.
//
//Создайте отчет о тестировании, преобразовав словарь с результатами тестирования (ключ — идентификатор теста, значение — результат) в список строк формата "Test ID: результат".
//
//Преобразуйте изменяемый словарь с результатами последнего тестирования в неизменяемый для архивации.
//
//Преобразуйте словарь, содержащий ID теста и данные о времени выполнения тестов, заменив идентификаторы тестов на их названия (название можно получить вызвав фейковый метод, например getNameById(id: String))
//
//Для словаря с оценками производительности различных версий приложения увеличьте каждую оценку на 10%, чтобы учесть новые условия тестирования.
//
//Проверьте, пуст ли словарь с ошибками компиляции тестов.
//
//Убедитесь, что словарь с результатами нагрузочного тестирования не пуст.
//
//Проверьте, прошли ли успешно все автоматизированные тесты в словаре с результатами.
//
//Определите, содержит ли словарь с результатами тестирования хотя бы один тест с ошибкой.
//
//Отфильтруйте словарь с результатами тестирования сервисов, оставив только те тесты, которые не прошли успешно и содержат в названии “optional”.
}


