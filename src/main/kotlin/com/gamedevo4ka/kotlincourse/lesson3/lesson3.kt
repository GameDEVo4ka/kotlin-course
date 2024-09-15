package com.gamedevo4ka.com.gamedevo4ka.kotlincourse.lesson3

val name: String = "Hackathon Survival" //Название мероприятия

var date: String = "00.00.00" //Дата проведения

var place: String = "Adress" //Место проведения

private val budget: String = "" //Подробный бюджет мероприятия, включая расходы на оборудование, кейтеринг и другие операционные расходы.

var member: Int = 0 //Количество участников
    get() = field
    private set(value) {field=value}

var duration: Long = 8*60*60 //Длительность хакатона

private lateinit var contactinformation: String = "" //Контактная информация и условия соглашений с поставщиками пищи, оборудования и других услуг.

var status: String = "Не начат" //Текущее состояние хакатона (статус)

val sponsors: String = "" //Список спонсоров

val budget: Int = 0 //Бюджет мероприятия

var internetAccessLevel: Int = 0 // Текущий уровень доступа к интернету

private var information: String = "" //Информация о транспортировке оборудования, распределении ресурсов и координации между различными командами поддержки.

var numberOfCommands: Int = 0 //Количество команд

val tasks: String = "" //Перечень задач

val evacuationPlan: String = "" //План эвакуации

var listOfAvailableEquipment: String = "" //Список доступного оборудования

var listOfFreeEquipment: String = "" //Список свободного оборудования

lateinit var mealSchedule: String = "" //График питания участников (зависит от поставщика питания, определяемого за неделю до начала)

val planInCaseOfFailures: String = "" //План мероприятий на случай сбоев

var listOfExpertsAndJury: String = "" //Список экспертов и жюри

val metod: String = "" //Методы и процедуры для сбора отзывов от участников и гостей, включая анонимные опросы и интервью.

private val privacyPolicy: String = "" //Политика конфиденциальности

private val privateReviews: String by lazy { "" } //Приватные отзывы (фидбэк) участников и зрителей для анализа проблем.

var temperatureIndoor: Int = 0 //Текущая температура в помещении

val monitoring: String = "" //Мониторинг и анализ производительности сетевого оборудования и интернет-соединения.

var lightingLevel: Int = 0 //Уровень освещения

private  val eventLog: String = "" //Лог событий мероприятия

val availabilityOfMedicalCare: Boolean = true //Доступность медицинской помощи

val securityPlan: String = "" //Планы и процедуры для обеспечения безопасности мероприятия, включая планы эвакуации и протоколы чрезвычайных ситуаций.

val eventRegistrationNumber: Int = 0 //Регистрационный номер мероприятия

val maximumPermissibleNoiseLevel: Int = 0 //Максимально допустимый уровень шума в помещении хакатона.

var noiseLevelIndicator: String = "" // Индикатор превышения уровня шума в помещениях

var eventFormat: String = "" //Формат мероприятия (зависит от геополитической обстановки)

var numberOfAvailableSeats: Int = 0
    get() = field
    set(value) {
        if (value >= 0) field += value
    }
//Количество свободных мест для отдыха (например, кресел или диванов), сеттер валидирует, чтобы количество не было меньше нуля.

val pressRelationsPlan: String = "" //План взаимодействия с прессой

private val projectInformation: String by lazy { "" } //Детальная информация о проектах каждой команды, сбор данных включает в себя компиляцию кода и сбор статистики прогона автоматизированных проверок.

var permissionStatus: String = "" //Статус получения всех необходимых разрешений

val exclusiveResources: Boolean = true or false //Указывает, открыт ли доступ к эксклюзивным ресурсам (например, специальному оборудованию)

val partners: String = "" //Список партнеров мероприятия

lateinit var report: String = "" //Отчет, включающий фотографии, видео и отзывы, генерируется и становится доступен после завершения мероприятия.

val prizeDistributionPlan: String = "" //План распределения призов

private val contactInformation: String = "" //Контактная информация экстренных служб, медицинского персонала и других важных служб, недоступная участникам.

val specialConditions: String = "" //Особые условия для участников с ограниченными возможностями

val mood: String by lazy { "" } //Общее настроение участников (определяется опросами)

lateinit var plan: String = "" //Подробный план хакатона, включающий время и содержание каждого сегмента, инициализируется непосредственно перед началом мероприятия

lateinit var specialGuest: String = "" //Имя знаменитого специального гостя, которое будет объявлено за день до мероприятия.

val maxCapacity: Int = 0 //Максимальное количество людей, которое может вместить место проведения.

val standardWorkHours: Int = 7*60*60 //Стандартное количество часов, отведенное каждой команде для работы над проектом.