package com.groovy.oop.trait

import groovy.transform.ToString

@ToString
class Car implements WithId{
    String brand
    String model
    Long power
}
