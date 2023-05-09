package com.groovy.oop.trait

class TraitExample {

    static void main(String[] args) {
        Car r8 = new Car(brand: "Audi", model: "R8", power: 100500, id: 1)
        println r8
        assert r8.validId()
        println ""

        Car rs6 = new Car(brand: "Audi", model: "RS6", power: 500)
        println rs6
        assert !rs6.validId()
    }

}
