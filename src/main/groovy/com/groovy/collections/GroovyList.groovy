package com.groovy.collections

class GroovyList {
    static void main(String[] args) {
        /**
         * Для инициализации коллекций в Groovy используются квадратные скобки [], а не фигурные {}
         */
        def list = [1, 2, 3, 4]
        assert list.getClass() == ArrayList

        /**
         * Способы чтения из списка в Groovy:
         * 1. по индексу элемента: list[n], где n - порядковый номер элемента
         * 2. по индексу элемента в обратном порядке
         * 3. через геттер
         * 4. можно получить подсписок указав порядковые номера элементов от и до
         * 5. если выйти за пределы массива, то получим null, а не исключение
         * 6. взять элемент из начала через метод head
         * 7. взять элемент из начала и удалить его через метод pop
         * 8. взять подсписок со всеми элементами после первого
         * 9. получить последний элемент из списка через метод last
         */
        assert list[2] == 3
        assert list[-1] == 4
        assert list.get(0) == 1
        assert list[0..2] == [1, 2, 3]
        assert list[10] == null
        assert list.head() == 1
        assert list.pop() == 1
        assert list == [2, 3, 4]
        assert list.tail() == [3, 4]
        assert list.last() == 4

        /**
         * Способы записи в список в Groovy:
         * 1. в конец списка через метод add
         * 2. в конец списка используя <<
         * 3. удалить все вхождения какого-либо значения можно через list -= x,
         * где x - элемент все вхождения, которого необходимо удалить
         * 4. удалить все вхождения нескольких значений можно через list -= [x,y,z....]
         * 5. продублировать n раз все вхождения списка можно через list *= n
         * 6. в начало списка через метод push
         */
        list = [1, 2, 3, 4]

        list.add(7)
        assert list == [1, 2, 3, 4, 7]

        assert list << 7 == [1, 2, 3, 4, 7, 7]

        list -= 7
        assert list == [1, 2, 3, 4]

        list = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
        list -= [5, 6, 7, 8, 9, 10]
        assert list == [1, 2, 3, 4]

        list *= 3
        assert list == [1, 2, 3, 4, 1, 2, 3, 4, 1, 2, 3, 4]

        list = [1, 2, 3, 4]
        list.push(0)
        assert list == [0, 1, 2, 3, 4]

        /**
         * Манипуляции со списками в Groovy:
         * 1. Если список внутри себя содержит подсписок,
         * то подсписок можно развернуть в список(что-то вроде flatMap из Stream) через метод flatten
         * 2. перевернуть список через метод reverse
         * 3. получить массив из элементов которые входят в другой массив(пересекаются) через метод intersect
         * 4. проверка пресечения элементов с другим списком через метод disjoint
         */
        list = [1, 2, 3, [4, 5, 6], 7, 8, 9]
        assert list.flatten() == [1, 2, 3, 4, 5, 6, 7, 8, 9]

        list = [1, 2, 3, 4]
        assert list.reverse() == [4, 3, 2, 1]

        assert list.intersect([3, 4, 5, 6,]) == [3, 4]

        assert list.disjoint([5, 6, 7, 8])
        assert !list.disjoint([4, 5, 6, 7])

        /**
         * можно присвоить значение сразу нескольким переменным используя список
         * значения будут присваиваться в по порядку элементов списка
         */

        def (x, y, z) = [10, 13, 25, 40, 57]
        assert x == 10
        assert y == 13
        assert z == 25

        /**
         * Можно передать массив в метод, который принимает несколько аргументов.
         * Чтобы элементы массива распределились на все аргументы метода нужно использовать spread оператор
         */
        list = [1, 2, 3]
        assert func(*list) == 6
    }

    static def func(def x, def y, def z) {
        return x + y + z
    }
}
