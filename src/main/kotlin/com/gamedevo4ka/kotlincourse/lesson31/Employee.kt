package com.gamedevo4ka.com.gamedevo4ka.kotlincourse.lesson31

data class Employee (
    val name: String,
    val employmentStatus: Boolean,
    val dateOfBirth: String,
    val position: CharacterTypes,
    val subordinatesList: List<Employee> = emptyList()
)