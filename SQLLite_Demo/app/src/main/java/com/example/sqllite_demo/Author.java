package com.example.sqllite_demo;

public class Author {
    private int idAuthor;
    private String name;
    private String address;
    private String email;

    public int getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(int idAuthor) {
        this.idAuthor = idAuthor;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Author() {
        this.idAuthor = 0;
        this.name = null;
        this.address = null;
        this.email = null;
    }


    public Author(int idAuthor, String name, String address, String email) {
        this.idAuthor = idAuthor;
        this.name = name;
        this.address = address;
        this.email = email;
    }


    @Override
    public String toString() {
        return "Author{" +
                "idAuthor=" + idAuthor +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
