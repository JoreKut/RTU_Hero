package com.company.Powers.Attackes;

import com.company.Characters.Powerable;
import com.company.Powers.Superpower;

public class RageSP extends Superpower implements Attackable {

    private final int minHealth;
    private final int percentOfAttackDamage;

    public RageSP(int minHealth, int percentOfAttackDamage){
        this.minHealth = minHealth;
        this.percentOfAttackDamage = percentOfAttackDamage;
    }

    @Override
    public void UseAttackPower(Powerable character) {
        character.RageMode(this.minHealth, this.percentOfAttackDamage);
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
