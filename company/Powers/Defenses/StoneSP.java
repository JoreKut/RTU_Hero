package com.company.Powers.Defenses;

import com.company.Characters.Powerable;
import com.company.Powers.Superpower;

import java.util.Random;

public class StoneSP extends Superpower implements Defensable {

    private final int percents;

    public StoneSP(int probability, int percents){
        this.probability = probability;
        this.percents = percents;
    }

    public void UseDefensePower(Powerable character){
        Random r = new Random();
        int n = r.nextInt(100);
        if(n < this.probability){
            LowCurEnemyDamage(character);
            System.out.println("Superpower \"STONE\" has worked ! Damage has lowed on " + this.percents + "%");
        }


        System.out.println(n + "/" + this.probability);
    }

    @Override
    public void LowCurEnemyDamage(Powerable character) {
        character.LowCurEnemyDamage(this.percents);
    }

    @Override
    public void ReflectEnemyDamage(Powerable c) {}
}
