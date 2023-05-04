package com.groovy.loops

class GroovyLoops {
    static void main(String[] args) {
        /**
         * При объявлении цикла for в Groovy достаточно написать for(i in 0..<list.size)
         */
        def list = List.of(1, 2, 3, 4, 5)
        for (i in 0..list.size()) {
            println i
        }

        println ""

        /**
         * При объявлении цикла foreach в Groovy достаточно написать for(value in list)
         */
        for (value in list) {
            println value * 2
        }

        println ""

        /**
         * Groovy позволяет использовать Closure для прохождения цикла:
         * x.upto(list.size()) {println it}
         * x.downTo(list.size()) {println it}
         */
        def x = 2
        x.upto(list.size()) {
            println it
            println it**2
        }
        println ""
        x.downto(0) {
            println it
            println it**2
        }

        println ""

        /**
         * Метод times у целочисленных типов позволяет повторять действие n раз,
         * где n - это и есть целое число
         */
        x.times {
            println "Hello World!"
        }

        println ""

        /**
         * Метод step у целочисленных типов позволяет повторять какое либо действие,
         * итерируясь с определенным шагом
         */
        x.step(10, 3, { println it }) // 3 итерации 2, 5, 8
    }

}
