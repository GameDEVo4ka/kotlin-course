package com.gamedevo4ka.kotlincourse.lesson27

fun timeTracker(fn: () -> Unit): Long {
    val startTime = System.currentTimeMillis()
    fn()
    val endTime = System.currentTimeMillis()
    return endTime - startTime
}

val myFunction = {
    val list = List(10_000_000) { (0..10_000).random() }
    list.sorted()
}

class Person(val name: String, val age: Int) {
    var email: String = ""
}

class Employee(val name: String, val age: Int, val position: String) {
    var email: String = ""
    var department: String = "General"
}



class Person(val name: String, val age: Int) {
    var email: String = ""
}

fun printPersonInfo(person: Person) {
    println("Name: ${person.name}, Age: ${person.age}, Email: ${person.email}")
}



fun createEmployee(person: Person?): Employee? {
    return person?.let {
        Employee(it.name, it.age, "Intern").apply {
            email = it.email
            department = "HR"
        }
    }
}




fun main() {
    val elapsedTime = timeTracker(myFunction)
    println("Execution time: $elapsedTime ms")




    val employee = Employee("John Doe", 30, "Developer").apply {
        email = "john.doe@example.com"
        department = "IT"
    }
    println("Name: ${employee.name}, Age: ${employee.age}, Position: ${employee.position}, Email: ${employee.email}, Department: ${employee.department}")




    val person = Person("Jane Doe", 25).also {
        it.email = "jane.doe@example.com"
        printPersonInfo(it)
    }



    val person = Person("Alice", 28)
    val employee = with(person) {
        Employee(name, age, "Manager").apply {
            email = person.email
        }
    }
    println("Name: ${employee.name}, Age: ${employee.age}, Position: ${employee.position}, Email: ${employee.email}, Department: ${employee.department}")


    val person = Person("Bob", 35).apply {
        email = "bob@example.com"
    }
    val employee = person.run {
        Employee(name, age, "Team Lead").apply {
            email = person.email
            department = "Development"
        }
    }
    println("Name: ${employee.name}, Age: ${employee.age}, Position: ${employee.position}, Email: ${employee.email}, Department: ${employee.department}")


    val person: Person? = Person("Charlie", 22).apply {
        email = "charlie@example.com"
    }
    val employee = createEmployee(person)
    println(employee?.let { "Name: ${it.name}, Age: ${it.age}, Position: ${it.position}, Email: ${it.email}, Department: ${it.department}" }
        ?: "No employee created")
}
