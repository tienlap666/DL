package com.example.sqlitetest;

public class Author {
    private int id;
    private String name;
    private String address;
    private String emial;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmial() {
        return emial;
    }

    public void setEmial(String emial) {
        this.emial = emial;
    }

    public Author() {
        this.id = 0;
        this.name = null;
        this.address = null;
        this.emial = null;
    }
    public Author(int id, String name, String address, String emial) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.emial = emial;
    }
}
