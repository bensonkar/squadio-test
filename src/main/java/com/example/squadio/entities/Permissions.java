package com.example.squadio.entities;

public enum Permissions {
    ADMIN("ADMIN"), USER("USER");

    String name;

    Permissions(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
