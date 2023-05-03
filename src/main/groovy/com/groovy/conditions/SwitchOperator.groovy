package com.groovy.conditions

class SwitchOperator {
    static def user = new User(999)

    static void main(String[] args) {
        /**
         *  Типы, которые можно передавать в switch в Java: byte, short, int, char, String, Enum
         *  В Groovy в оператор switch можно передавать любые типы
         */

        int x = 50

        switchOperator(x.toString())
        switchOperator(x)
        switchOperator(15)
        switchOperator(133)
        switchOperator(999L)
        switchOperator(138)
        switchOperator("ABC")
    }

    static void switchOperator(Object o) {
        switch (o) {
            case String:
                println "This is String"
                break
            case 50:
                println o
                break
            case { it % 5 == 0 }:
                println "There is number without remainder"
                break
            case [1, 2, 4, 25, 50, 125, 133]:
                println "Current dim included to the array"
                break
            case user:
                println "Bingo!!!"
                break
            case ~/\d+/:
                println "There is 1 digit at least"
                break
            default:
                println "There is no matches"
                break
        }
    }
}
