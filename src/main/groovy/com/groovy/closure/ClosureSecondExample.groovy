package com.groovy.closure

import com.groovy.oop.Person

class ClosureSecondExample {

    static void main(String[] args) {
        Closure closure = { firstName = "Petr" }
        assert closure.owner == ClosureSecondExample.class
        assert closure.delegate == ClosureSecondExample.class
        assert closure.thisObject == ClosureSecondExample.class

        def person = new Person("Ivan", "Ivanov", 18)
        assert person.firstName == "Ivan"

        // 1-й способ вызвать Closure для конкретного объекта
        /*closure.delegate = person
        closure.resolveStrategy = Closure.DELEGATE_FIRST
        closure()*/

        // 2-й способ вызвать Closure для конкретного объекта
        person.with closure

        assert person.firstName == "Petr"

        person.getInfo().call()
    }
}
