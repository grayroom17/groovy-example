package com.groovy.tasks.task1

import com.groovy.oop.Person

class Task1 {

    static void main(String[] args) {
        Class.metaClass.make { Object[] values ->
            println thisObject
            println owner
            println delegate

            delegate.metaClass.invokeConstructor()
        }

        def hashSet = HashSet.make([1, 2, 3, 4, 5, 5, 5])
        println hashSet
        println ""

        def person1 = Person.make("Ivanov", "Ivan", 18)
        println person1
        println ""

        def person2 = Person.make()
        println person2
    }

}
