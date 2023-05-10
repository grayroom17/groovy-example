package com.groovy.dsl

class MailSpecification {
    String from
    String to
    String title
    EmailBodySpecification body

    def from(String from) {
        this.from = from
    }

    def to(String to) {
        this.to = to
    }

    def title(String title) {
        this.title = title
    }

    def body(@DelegatesTo(EmailBodySpecification) Closure closure) {
        body = new EmailBodySpecification()
        body.with closure
    }

}
