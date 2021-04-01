package com.example.trainingapp1.model;

import java.util.Objects;

public class Player {
    private String mFirstName;

    public Player(String FirstName) {
        this.mFirstName = FirstName;
    }
    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String FirstName) {
        this.mFirstName = FirstName;
    }

    @Override
    public boolean equals(Object o) {
        Player p = (Player) o;
        return this.mFirstName.equals(p.getFirstName());
    }

    @Override
    public int hashCode() {
        return this.mFirstName.hashCode();
    }

    @Override
    public String toString() {
        return "Player{" +
                "FirstName : " + mFirstName + " }";
    }
}
