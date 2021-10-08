package com.company.Powers.Attackes;

import com.company.Characters.Powerable;
import com.company.Powers.Superpower;

import java.util.Random;

public class FreezeSP extends Superpower implements Attackable {

    private final int time;

    public FreezeSP(int time, int probability){
        this.time = time;
        this.probability = probability;
    }

    @Override
    public void UseAttackPower(Powerable character){
        Random r = new Random();
        int n = r.nextInt(100);
        if(n < this.probability){
            try {
                System.out.println("[: Enemy is freeze on " + this.time + "seconds ^_^");
                character.FreezeEnemy(this.time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public void PoisonHit(Powerable character) {

    }

    @Override
    public void FreezeEnemy(Powerable character) {

    }

    @Override
    public void RageMode(Powerable character) {

    }
}
