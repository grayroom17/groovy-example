package com.groovy.collections

class GroovyRange {

    static void main(String[] args) {
        /**
         * инициализация Range, когда указанные границы включены в Range: x..y
         * инициализация Range, когда правая граница не включена в Range: x..<y
         */
        def range = 5..<11
        assert range.getClass() == IntRange

        /**
         * Чтение из Range:
         * 1. через метод get
         * 2. проверка на вхождение элемента через метод contains
         */
        assert range.get(2) == 7
        assert range.contains(10)
        assert !range.contains(11)
    }
}
