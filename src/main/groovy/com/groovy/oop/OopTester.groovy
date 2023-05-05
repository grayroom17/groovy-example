package com.groovy.oop

class OopTester {
    static void main(String[] args) {
        def person = new Person()
        person.firstName = "John" // будет вызван  person.setFirstName("John")
        person.setLastName("Doe")
        person.setAge(25)

        assert person.firstName == "John"
        assert person.'lastName' == "Doe"
        assert person['age'] == 25
//        assert person.@firstName == "John" // прямой доступ к полю

        def ivan = new Person(firstName: "Ivan", lastName: "Pupkin", age: 18)
        println ivan

        println ""

        Person petr = ["Petr", "Petrov", 21]
        println petr

        assert [person, ivan, petr].collect({ it.firstName }) == ["John", "Ivan", "Petr"]
        assert [person, ivan, petr]*.firstName == ["John", "Ivan", "Petr"]
    }
}
