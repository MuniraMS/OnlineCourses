package com.example.assignment.model;

public class student {
    private String name;
    private int ID;
    private int level;
    private String username;
    private String password;

    public student () {}
    public student(String name, int ID, int level, String username, String password) {
        this.name = name;
        this.ID = ID;
        this.level = level;
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
