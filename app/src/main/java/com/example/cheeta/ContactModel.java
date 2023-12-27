package com.example.cheeta;

public class ContactModel {

    private int id;
    private String name;
    private int img;
    private String message;

    public ContactModel(int id, String name, int img, String message) {
        this.id = id;
        this.name = name;
        this.img = img;
        this.message = message;
    }

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

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
