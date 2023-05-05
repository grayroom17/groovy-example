package com.groovy.iteration

class GroovyIterates {

    /**
     * Методы позволяющие итерироваться по любым объектам:
     * 1.   any - найти хотя бы одно соответствие условию, возвращает boolean
     * 2.   collect - вернуть коллекцию
     * 3.   each - обычное итерирование
     * 4.   eachWithIndex -
     * 5.   every - возвращает true, если все элементы удовлетворяют условию
     * 6.   find - найти первый элемент удовлетворяющий условию
     * 7.   findAll - найти все элементы удовлетворяющие условию
     * 8.   findIndexOf - возвращает индекс первого элемента удовлетворяющего условию
     * 9.   findIndexValues - возвращает индексы элементов удовлетворяющих условию
     * 10.  findLastIndexOf - возвращает индекс последнего элемента удовлетворяющего условию
     * 11.  inject - превратить коллекцию в единый объект
     * 12.  split - разбиение на коллекции по какому-то признаку
     * 13.  grep - что-то вроде фильтра
     */

    static void main(String[] args) {
        assert [1, 3, 5, 8, 11, 12, 15].any({ it % 2 == 0 })
        assert [1, 3, 5, 8, 11, 12, 15].find({ it % 2 == 0 }) == 8
        assert [1, 3, 5, 8, 11, 12, 15].findAll({ it % 2 == 0 }) == [8, 12]
        assert (1..3).collect() == [1, 2, 3]
        assert ["afsfa", 123, "ddsfas", 4646, "dfsdfsdf"].grep(~/\d+/) == [123, 4646]
        assert ["sfs", "dsf", "dfsdfs", "dgg", "dsfssf", "aaaaa"].grep({ it.length() > 4 }) == ["dfsdfs", "dsfssf", "aaaaa"]
    }
}