package com.company.Powers;

import com.company.GameObject;

public class Superpower extends GameObject {
    public int AccessLevel;
    public int Price;
    public int probability;


    public Superpower(){}

    public void setProbability(int probability) {
        this.probability = probability;
    }

    @Override
    public String toString() {
        return "Superpower{" +
                "Name='" + Name + '\'' +
                ", Level=" + Level +
                ", AccessLevel=" + AccessLevel +
                ", Price=" + Price +
                '}';
    }
}
