package com.company.Powers.Defenses;

import com.company.Characters.Powerable;

public interface Defensable{
    void UseDefensePower(Powerable character);
    void LowCurEnemyDamage(Powerable character);
    void ReflectEnemyDamage(Powerable character);
}
