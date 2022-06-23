package com.example.mychat;

public class MessageToSend {
    public int Id;
    public String content;
    public String created;
    public boolean sent;

    public int getId() {
        return Id;
    }

    public MessageToSend() {
    }

    public MessageToSend(int id, String content, String created, boolean sent) {
        Id = id;
        this.content = content;
        this.created = created;
        this.sent = sent;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public boolean isSent() {
        return sent;
    }

    public void setSent(boolean sent) {
        this.sent = sent;
    }
}
