package com.groovy.variables

import java.util.regex.Matcher
import java.util.regex.Pattern

def text = "abc abc 1 def 2 ghi 34 jkl 567 mno"

def javaRegEx = "\\w+ \\d+ "
def groovyRegEx = /\w+ \d+ /
Pattern javaPattern = Pattern.compile(javaRegEx)
Pattern groovyPattern = ~groovyRegEx

Matcher javaMatcher = javaPattern.matcher(text)
Matcher groovyMatcher = groovyPattern.matcher(text)

while (javaMatcher.find()) {
    println javaMatcher.group()
}
println ""
while (groovyMatcher.find()) {
    println groovyMatcher.group()
}