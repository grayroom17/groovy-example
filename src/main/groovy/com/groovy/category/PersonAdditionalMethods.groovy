package com.groovy.category

import com.groovy.oop.Person

@Category(Person.class)
class PersonAdditionalMethods {

    def testStr() {
        println "Age: $age, first name: $firstName"
    }
}
