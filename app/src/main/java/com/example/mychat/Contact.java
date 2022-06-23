package com.example.mychat;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Contact {
    @NonNull
    @PrimaryKey
    private String  id;
    private String name;


    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    private String server;
    private String last;
    private String lastdate;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getLastdate() {
        return lastdate;
    }

    public void setLastdate(String lastdate) {
        this.lastdate = lastdate;
    }

    public Contact(String id, String name, String last, String lastdate ,String server) {
        this.id = id;
        this.name = name;
        this.last = last;
        this.lastdate = lastdate;
        this.server=server;
    }
    public Contact(String id, String name,String server) {
        this.id = id;
        this.name = name;
        this.server=server;
    }

    public Contact() {
    }

    @Override
    public String toString() {
        return "Contact{" +
                "Id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", server='" + server + '\'' +
                '}';
    }
}
