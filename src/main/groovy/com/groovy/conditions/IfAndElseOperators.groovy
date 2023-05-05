package com.groovy.conditions

class IfAndElseOperators {
    static void main(String[] args) {
        /**
         * if оператор в Groovy понимает не только логические значения true и false,
         * он так же понимает пустая коллекция(или Map) или нет
         */
        def list = List.of(1, 2, 3)
        def emptyList = Collections.emptyList()

        assert !isCollectionEmpty(list)
        assert isCollectionEmpty(emptyList)
        assert isCollectionNotEmpty(list)
        assert !isCollectionNotEmpty(emptyList)

        /**
         * if оператор в Groovy понимает пустая строка или нет
         */
        def string = "Abc"
        def emptyString = ""

        assert isStringEmpty(emptyString)
        assert !isStringEmpty(string)
        assert isStringNotEmpty(string)
        assert !isStringNotEmpty(emptyString)

        /**
         * if оператор в Groovy проверяет Number и Char на равенство 0
         */
        int notNullInteger = 1
        int nullInteger = 0

        assert isNumberNull(nullInteger)
        assert !isNumberNull(notNullInteger)
        assert isNumberNotNull(notNullInteger)
        assert !isNumberNotNull(nullInteger)

        char notNullChar = 1
        char nullChar = 0

        assert isCharNull(nullChar)
        assert !isCharNull(notNullChar)
        assert isCharNotNull(notNullChar)
        assert !isCharNotNull(nullChar)

        /**
         * if оператор в Groovy проверяет Reference на null и 0
         */
        Closure closure = {
            if (it) {
                return true
            } else return false
        }
        assert closure(notNullInteger)
        assert !closure(nullInteger)

        def nullUser = new User(1000)
        def notNullUser = new User(100_001)
        assert closure(notNullUser)
        assert !closure(nullUser)

        /**
         * В Groovy есть дефолтный null-safe оператор ?. ,
         * который проверяет объект на null
         */
        println notNullUser?.getId()

        /**
         * тернарный оператор в Java: y = x != null ? x : 10
         * тернарный оператор в Groovy: y = x ? x : 10
         * тернарный оператор в Groovy (сокращенная запись): y = x ?: 10
         */

        def x1 = null
        def x2 = 20
        def y1 = x1 ?: 10
        def y2 = x2 ?: 10
        assert y1 == 10
        assert y2 == 20
    }

    static boolean isCollectionNotEmpty(Collection collection) {
        if (collection) {
            return true
        } else return false
    }

    static boolean isCollectionEmpty(Collection collection) {
        return !collection
    }

    static boolean isStringNotEmpty(String string) {
        if (string) {
            return true
        } else return false
    }

    static boolean isStringEmpty(String string) {
        return !string
    }

    static boolean isNumberNotNull(Number number) {
        if (number) {
            return true
        } else return false
    }

    static boolean isNumberNull(Number number) {
        return !number
    }

    static boolean isCharNotNull(Character c) {
        if (c) {
            return true
        } else return false
    }

    static boolean isCharNull(Character c) {
        return !c
    }
}
