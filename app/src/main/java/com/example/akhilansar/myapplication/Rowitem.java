package com.example.akhilansar.myapplication;

/**
 * Created by akhil ansar on 06-11-2016.
 */

class Rowitem {
    String title;
    String body;

    public Rowitem(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
