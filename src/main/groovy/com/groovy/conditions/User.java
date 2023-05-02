package com.groovy.conditions;

public class User {

    Long id;

    public User(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean asBoolean() {
        return getId() > 100_000;
    }
}
