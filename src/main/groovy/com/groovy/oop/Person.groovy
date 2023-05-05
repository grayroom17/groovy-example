package com.groovy.oop

import groovy.transform.ToString
import groovy.transform.TupleConstructor

@ToString
@TupleConstructor
class Person {
    String firstName
    String lastName
    Integer age
}
