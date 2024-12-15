package com.gamedevo4ka.kotlincourse.lesson28

//Задача 1
//Создайте текстовый файл workspace/task1/example.txt
//запишите в него строку "Hello, Kotlin!", а затем проверьте, существует ли файл.

fun main () {
    val file1 = File("workspace/task1/example.txt")
    file1.parentFile.mkdirs()
    file1.createNewFile()
    file1.writeText("Hello, Kotlin!")

    if (file1.exists()) {
        println(
            "Файл существует"
        )
    } else {
        println(
            "Файл не найден")
    }

//Задача 2
//Создайте директорию workspace/task2/testDir
//проверьте, является ли она директорией, и выведите её абсолютный путь.

    val dir1 = File("workspace/task2/testDir")
    dir1.mkdirs()
    if (dir1.isDirectory) {
        println(dir1.absolutePath)
    } else {
        println("This is not a directory")
    }

//Задача 3
//Создайте директорию workspace/task3/structure.
//Внутри директории structure создайте папку myDir с двумя вложенными поддиректориями subDir1 и subDir2. Проверьте, что myDir действительно содержит эти поддиректории.

    val dir2 = File("workspace/task3/structure/")
    dir2.mkdirs()
    val myDir = File(dir2, "myDir")
    myDir.mkdir()
    val subDir1 = File(myDir, "subDir1")
    val subDir2 = File(myDir, "subDir2")
    subDir1.mkdir()
    subDir2.mkdir()
    val subDirs = myDir.listFiles()
    subDirs?.forEach { file ->
        println(file.name)
    }

//Задача 4
//Создайте директорию workspace/task4/temp.
//Внутри директории temp создайте несколько вложенных файлов и директорий. Удалите директорию workspace/task4 со всем содержимым
    val dir3 = File("workspace/task4/temp/tempDir/file3.txt")
    dir3.parentFile.mkdirs()
    val tempFile = File(dir3, "workspace/task4/temp/file.txt")
    tempFile.createNewFile()
    val tempFile2 = File(dir3, "workspace/task4/temp/file2.txt")
    tempFile2.createNewFile()
    tempFile.createNewFile()
    dir3.createNewFile()
    val deleteDer = File("workspace/task4")
    deleteDer.deleteRecursively()

//Задача 5
//Создайте файл workspace/task5/config/config.txt
//запишите в него список параметров (в формате ключ=значение), а затем прочитайте файл и выведите только значения.
    val file2 = File("workspace/task5/config/config.txt")
    file2.parentFile.mkdirs()
    file2.createNewFile()
    val list = listOf("one" to "1", "two" to "2", "three" to "3")
    file2.writeText(list.joinToString("\n"))
    val values = file2.readLines().mapNotNull { it.split("=").getOrNull(1) }
    values.forEach { println(it) }

//Задача 6
//Пройди по всем вложенным директориям workspace и выведи в консоль сначала пути директорий, а потом пути файлов

    fun task6() {
        val rootDir = File("workspace")
        if (rootDir.exists()) {
            println("List of directories and files")
            rootDir.walkTopDown().forEach {
                if (it.isDirectory) {
                    println("Directory: ${it.absolutePath}")
                } else {
                    println("File: ${it.absolutePath}")
                }
            }
        } else {
            println("The directory workspace does not exist")
        }
    }

//Задача 7
//Создайте директорию workspace/task9/docs.
//Проверь, есть ли файл с именем readme.md. Если файла нет, создайте его и запишите текст "This is a README file."

    val workspace = File("workspace/task9/docs")
    workspace.mkdirs()

    val readmeFile = File(workspace, "workspace/task9/docs/readme.md")
    if (readmeFile.exists()) {
        println("file exist")
    }   else {
        readmeFile.createNewFile()
        readmeFile.writeText("This is a README file.")
    }

}