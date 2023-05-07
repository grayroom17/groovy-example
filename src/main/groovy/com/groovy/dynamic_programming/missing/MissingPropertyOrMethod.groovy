package com.groovy.dynamic_programming.missing

import com.groovy.conditions.User
import com.groovy.oop.Person

class MissingPropertyOrMethod {

    static void main(String[] args) {

        def person = new Person()
        person.someMethod()
        person.someField
    }
}
