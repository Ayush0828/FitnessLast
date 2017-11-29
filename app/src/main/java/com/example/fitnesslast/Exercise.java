package com.example.fitnesslast;

/**
 * Created by haawh on 29/11/2017.
 */

public abstract class Exercise {

    private String description;


    abstract void run(); /*chronometre*/

    abstract void delete();

    abstract void edit();

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
