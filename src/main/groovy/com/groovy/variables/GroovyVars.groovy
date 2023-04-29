package com.groovy.variables

import groovy.transform.CompileStatic

import java.sql.Date as SqlDate
import java.time.LocalDate
import java.time.ZoneOffset

class GroovyVars {


    /**
     * byte, int, long, BigInteger
     * float, double, BigDecimal
     * char
     * boolean
     *
     * Все примитивные типы из Java в Groovy автоматически оборачиваются ссылочными аналогами
     *
     * В импортах можно задавать alias и обращаться заданному alias
     *
     * В Groovy есть свой аналог динамической переменной (var в Java) - def
     */
    @CompileStatic
    static void main(String[] args) {
        long longValue = 1 // по факту будет Long и с этой переменной можно работать как с ссылочным типом
        println longValue.toString()


        BigInteger bigIntegerValue = 1000G

        Date javaUtilDate = new Date() // Date из пакета java.util
        // Date из пакета java.sql
        SqlDate sqlDate = new SqlDate(
                LocalDate.of(2023, 4, 29).atStartOfDay()
                .toInstant(ZoneOffset.UTC)
                .toEpochMilli())

        def defaultIntValue = 10 // по дефолту, как и в Java, берется int. Далее int оборачивается Integer
    }
}
