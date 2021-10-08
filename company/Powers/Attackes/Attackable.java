package com.company.Powers.Attackes;

import com.company.Characters.Character;
import com.company.Characters.Powerable;

public interface Attackable{
    void UseAttackPower(Powerable character) throws InterruptedException;
    void PoisonHit(Powerable character);
    void FreezeEnemy(Powerable character);
    void RageMode(Powerable character);
}
