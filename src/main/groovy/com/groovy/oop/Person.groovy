package com.groovy.oop

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Person {
    String firstName
    String lastName
    Integer age

    def methodMissing(String name, Object arguments) {
        println "Missing method $name was invoked: $arguments"
    }

    def propertyMissing(String name) {
        println "Missing property $name was called"
        "default value"
    }

    @SuppressWarnings('GrMethodMayBeStatic')
    def getInfo() {
        Closure closure = {
            println thisObject
            println owner
            println delegate

            Closure innerClosure = {
                println thisObject
                println owner
                println delegate
            }
            innerClosure()
        }
        closure
    }
}
