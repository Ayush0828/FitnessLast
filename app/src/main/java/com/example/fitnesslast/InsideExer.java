package com.example.fitnesslast;

/**
 * Created by haawh on 29/11/2017.
 */

public class InsideExer extends Exercise {

    private int nbseries;
    private int lengthseries;
    private String machine;


    public InsideExer(int nb, int lg, String d){
        this.setNbseries(nb);
        this.setLengthseries(lg);
        this.setDescription(d);
    }

    @Override
    void run() {
    }

    @Override
    void delete() {
    }

    @Override
    void edit() {
    }

    public int getNbseries() {
        return nbseries;
    }

    public void setNbseries(int nbseries) {
        this.nbseries = nbseries;
    }

    public int getLengthseries() {
        return lengthseries;
    }

    public void setLengthseries(int lengthseries) {
        this.lengthseries = lengthseries;
    }
}
