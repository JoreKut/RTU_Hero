package com.company.Characters;

public interface Powerable {
    void LowCurEnemyDamage(int percents);
    void ReflectEnemyDamage(int percents);
    void PoisonHit(int time, int damagePerSecond);
    void FreezeEnemy(int time) throws InterruptedException;
    void RageMode(int minHealth, int percentOfAttackDamage);
}
