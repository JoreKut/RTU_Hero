package com.company.Powers.Defenses;

import com.company.Characters.Powerable;
import com.company.Powers.Superpower;

import java.util.Random;

public class SpikeSP extends Superpower implements Defensable {

    private final int percents;

    public SpikeSP(int probability, int percents){
        this.probability = probability;
        this.percents = percents;
    }

    @Override
    public void UseDefensePower(Powerable character) {
        Random r = new Random();
        int n = r.nextInt(100);

        if(n < this.probability){
            ReflectEnemyDamage(character);
            System.out.println("Superpower \"SPIKE\" has worked !");
        }

        System.out.println(n + "/" + this.probability);

    }

    @Override
    public void LowCurEnemyDamage(Powerable c) {

    }

    @Override
    public void ReflectEnemyDamage(Powerable c) {
        c.ReflectEnemyDamage(this.percents);
    }
}
