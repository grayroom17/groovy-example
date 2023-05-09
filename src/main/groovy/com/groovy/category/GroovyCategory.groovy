package com.groovy.category

import com.groovy.oop.Person

class GroovyCategory {

    static void main(String[] args) {
        def person = new Person("age": 18, firstName: "Ivan")
        use(PersonAdditionalMethods.class) {
            person.testStr()
        }
        person.testStr()
    }
}
