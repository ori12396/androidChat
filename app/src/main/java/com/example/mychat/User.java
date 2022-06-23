package com.example.mychat;

public class User {
    public String Id;
    public String password;
    public String Name;

    public User(String id, String password, String name) {
        Id = id;
        this.password = password;
        Name = name;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
