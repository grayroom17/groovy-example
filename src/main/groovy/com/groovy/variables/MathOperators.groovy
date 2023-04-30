package com.groovy.variables

assert 1 + 2 == 3
assert 3 - 2 == 1

assert 2 * 2 == 4
assert 4 / 2 == 2

assert 11 % 3 == 2
assert 10.intdiv(3) == 3 // НОД
assert 10.intdiv(10) == 1 // НОД

assert 4**4 == 256 //возведение в степень

assert (3 / 2) as Integer == 1

assert 3 == +3
assert 0 - 3 == -3
assert -(-3) == +3

assert 2++ + 3 == 5
assert ++2 + 3 == 6

