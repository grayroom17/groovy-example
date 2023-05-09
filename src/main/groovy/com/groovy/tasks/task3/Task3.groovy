package com.groovy.tasks.task3

import static groovy.lang.Closure.DELEGATE_ONLY

class Task3 {

    static void main(String[] args) {
        given {
            a = 1
            b = 2
        } when {
            result = a + b
        } then {
            result == 3
        }
    }

    static def given(Closure closure) {
        def valueHolder = [:]
        closure.delegate = valueHolder
        closure.resolveStrategy = DELEGATE_ONLY
        closure()
        [when: {
            Closure whenClosure ->
                {
                    whenClosure.delegate = valueHolder
                    whenClosure.resolveStrategy = DELEGATE_ONLY
                    whenClosure()
                    [then: {
                        Closure thenClosure ->
                            {
                                thenClosure.delegate = valueHolder
                                thenClosure.resolveStrategy = DELEGATE_ONLY
                                assert thenClosure()
                            }
                    }]
                }
        }]
    }

}
