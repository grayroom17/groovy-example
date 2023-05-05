package com.groovy.collections

class GroovyMaps {

    static void main(String[] args) {
        /**
         * Инциализация Map в Groovy:
         * 1. пустой ассоциативный массив [:]
         * 2. [key:value, key1:value1, key2:value2, ....]
         */
        def emptyMap = [:]
        assert emptyMap.getClass() == LinkedHashMap

        def map = ["key1": 1, "key2": 2, "key3": 3]
        assert map.getClass() == LinkedHashMap

        /**
         * Чтение из Map:
         * 1. получить значение по ключу через метод get
         * 2. получить значение по ключу, как через индекс map["key"]
         * 3. получить значение по ключу через точечную нотацию map."key",
         * а если в качестве ключа используется String, то кавычки можно убрать
         * 4. через метод get можно установить дефолтное значение, если искомый ключ отсутствует в массиве get("key", 10). что-то вроде computeIfAbsent
         * 5. получение под связанного подмассива через метод submap
         */
        assert map.get("key1") == 1
        assert map["key2"] == 2
        assert map."key3" == 3
        assert map.key3 == 3
        assert map.get("key4", 10) == 10
        assert map.subMap("key1", "key3") == ["key1": 1, "key3": 3]

        /**
         * Запись в Map:
         * 1. через методы put, putAll
         * 2. через точечную нотацию map.key = value
         * 3. добавление всех элементов другого массива через spread оператор *:
         */
        map.put("key4", 4)
        assert map.key4 == 4
        map.key5 = 5
        assert map.key5 == 5
        def newMap = ["key-1": -1, "key0": 0, *: map]
        assert newMap == ["key-1": -1, "key0": 0, "key1": 1, "key2": 2, "key3": 3, "key4": 4, "key5": 5]

    }
}
