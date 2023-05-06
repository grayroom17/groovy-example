package com.groovy.dynamic_programming

import com.groovy.conditions.User

class GroovyMetaClass {

    static void main(String[] args) {
        def user = new User(1)

        user.metaClass.newField = "Abc"//динамическое добавление нового поля в объект класса User
        user.metaClass.newMethod = { //динамическое добавление нового метода в объект класса User
            int x, int y -> x + y
        }

        assert user.newField == "Abc"
        assert user.newMethod(1, 2) == 3
    }
}
