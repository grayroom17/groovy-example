package com.groovy.io

class GroovyIO {

    static void main(String[] args) {
        //чтение из файла целиком
        File file = new File(".gitignore")
        println file.text

        println "======================================="

        //чтение из файла построчно
        file.grep({ println it })
        println "======================================="

        //чтение из input stream
        file.withInputStream {
            def allText = new String(it.readAllBytes())
            println allText
        }

        //запись в файл
        def newFile = new File("text.txt")
        newFile.text = "Blah Blah Blah"//перетирает весь текст
        newFile << System.lineSeparator()
        newFile << "one else line"//добавляет новую строку
    }
}
