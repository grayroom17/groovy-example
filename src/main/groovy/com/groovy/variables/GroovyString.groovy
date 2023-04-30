package com.groovy.variables

/**
 * В Groovy строки можно писать 6-ю разными способами:
 * 1. "Text" - внутри строки можно обращаться к переменным и параметрам или функциям через $(интерполяция): "value: $someParamValue"
 * 2. 'Text' - внутри можно использовать двойные кавычки без экранирования, но нельзя использовать интерполяцию: '"Text"'
 * 3. """Text""" - внутри можно использовать двойные или одинарные кавычки без экранирования, переносить строки,
 *                                                                                     использовать интерполяцию: """
 *                                                                                                                'Text'
 *                                                                                                                "Text"
 *                                                                                                                $someValue
 *                                                                                                                """
 * 4. '''Text''' - внутри можно использовать двойные или одинарные кавычки без экранирования,переносить строки
 *                                                                           но нельзя использовать интерполяцию: """
 *                                                                                                                'Text'
 *                                                                                                                "Text"
 *                                                                                                                """
 * 5. /Text/ - внутри можно использовать двойные одинарные кавычки, и back-slash(\) без экранирования, переносить строки,
 *                                                                                     использовать интерполяцию: /
 *                                                                                                                'Text'
 *                                                                                                                "Text"
 *                                                                                                                \Text\
 *                                                                                                                $someValue
 *                                                                                                                /
 * 6. $/Text/$ - внутри можно использовать двойные,одинарные кавычки и знак доллара($) без экранирования, переносить строки,
 *                                                                                     использовать интерполяцию: $/
 *                                                                                                                'Text'
 *                                                                                                                "Text"
 *                                                                                                                $someValue
 *                                                                                                                /$
 * Со строками можно работать как с массивами: someString[0] вернет 1-й символ с начала,
 *                                             someString[-1] вернет 1-й символ с конца,
 *                                             someString[0..2] вернет с 1-го по 3-й символы с начала,
 *                                             someString[-1..-3] вернет с 1-го по 3-й символы с конца в обратном порядке
 */
//1
def paramValue = 100
assert "value: 100" == "value: $paramValue"
println "value: $paramValue"
println ""

//2
assert '\"SomeText\"' == '"SomeText"'
println '"SomeText"'
println ""

//3
def expected = "select *\n" +
        "from users\n" +
        "where id = 1"

def userId = 1

def actual = """select *
from users
where id = $userId"""

assert expected == actual

println expected
println ""

//4
expected = "there\n" +
        "must be\n" +
        "\"some text\"\n" +
        "and then \$someValue"

actual = '''there
must be
"some text"
and then $someValue'''

assert expected == actual

println actual
println ""

//5
expected = "this feature\n" +
        "\\is usually\n" +
        "used in\\ regular expressions"

actual = /this feature
\is usually
used in\ regular expressions/

assert expected == actual

println actual
println ""

//6
expected = "i want\n" +
        "\$100500 salary but \$\$100\$\$ "

actual = $/i want
$100500 salary but $$$$100$$$$ /$

assert expected == actual

println actual

def stringAsArray = "0123456789"
assert "0" == stringAsArray[0]
assert "9" == stringAsArray[-1]
assert "012" == stringAsArray[0..2]
assert "987" == stringAsArray[-1..-3]

def someString = "Abc"
assert "AbcAbcAbc" == someString * 3
assert "bc" == someString - "A"
assert "Ac" == someString - "b"
