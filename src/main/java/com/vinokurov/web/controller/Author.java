package com.mkyong.web.controller;

/**
 * Created by Alex on 06.07.2016.
 */
public class Author {

    private String id;
    private String first_name;
    private String second_name;

    Author(String id, String first_name, String second_name) {
        this.id = id;
        this.first_name = first_name;
        this.second_name = second_name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setSecond_name(String second_name) {
        this.second_name = second_name;
    }

    public String getId() {
        return id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getSecond_name() {
        return second_name;
    }
    public String toString() {
        return getId();
    }
}
