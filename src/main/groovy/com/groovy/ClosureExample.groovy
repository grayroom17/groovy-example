package com.groovy

import java.util.function.Function
import java.util.stream.Stream

class ClosureExample {
    static void main(String[] args) {
        Function<Integer, Integer> func = value -> value + value

        Stream.of(1, 2, 3, 4, 5)
                .map(func)
                .map(String::valueOf)
                .forEach(System.out::println)

        println ""

        /**
         * Closure - это приватная функция
         */
        Closure closure = { value -> value + value }

        Stream.of(1, 2, 3, 4, 5)
                .map(closure)
                .map(String::valueOf)
                .forEach(System.out::println)


        /**
         * Closure принято выделять фигурными скобками
         */
        closure = { value ->
            value * 3
            value * 2
        }

        /**
         * Вызвать выполнение Closure можно через метод call передав в него аргумент
         * либо просто вызвам сам объект Closure и передав в него аргументы
         */
        println ""
        println closure.call(16)
        assert closure.call(16) == closure(16)
        assert closure(16) == 32

        /**
         * Если Closure имеет единственный аргумент, то его необязательно объявлять,
         * т.к. в Closure есть зарезервированное ключевое слово it
         */
        closure = {
            it * 2
            it * 3
        }
        println ""
        assert closure(3) == 9

        /**
         * Если нужна Closure без аргументов, то нужно просто указать ->
         */
        closure = { ->
            println "Foo"
            println "Bar"
        }
        closure()
        println ""

        /**
         * Closure умеет ссылаться на методы подобно Java,
         * только вместо :: нужно использовать .&
         * В результате так же вернется Closure
         */
        closure = { it * 2 }
        Stream.of(1, 2, 3, 4, 5)
                .map(closure)
                .map(String.&valueOf)
                .forEach(System.out::println)
        println ""

        /**
         * В Closure можно задать дефолтные параметры
         */
        closure = { value = 25 -> value * 2 }
        assert closure() == 50
        println closure()
        println ""

        /**
         * В Closure можно передавать не final переменные и менять их внутри Closure.
         * Изменения проделанные внутри Closure будут записаны в локальную переменную
         */
        def x = 10
        methodWithCallback(x > 0, {
            x = x**2
            println x
        })
        assert x == 100
        println ""

        /**
         * Если Closure передается последним аргументом в какой-то метод, то в метод можно передать все предыдущие
         * аргументы, закрыть скобку и объявить Closure внутри фигурных скобок
         */
        x = 5
        methodWithCallback(x > 0) {
            x = x**3
            println x
        }
        assert x == 125
    }

    static def methodWithCallback(boolean condition, Closure closure) {
        if (condition) {
            closure()
        }
    }
}
