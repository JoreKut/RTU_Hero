package com.company.Characters;

import com.company.Items.ArmorType;

public interface AliveCharacter {
    boolean IsAlive();
    void ShootToEnemy();
    void GetDamage(int Damage, ArmorType type);

    void StartFighting();
    void Freeze(int time) throws InterruptedException;
    /*

    void SetEnemy(Character Enemy);
    void SetWeapon(Shootable weapon);
    void SetArmor(Armor armor);
    void SetSuperPower(Usable superpower);

    */

    void WinnerMessage();
    void LoserMessage();
    void Die();

    void GetLoot();
    int[] DropLoot();

    /*
    void Freeze(int time) throws InterruptedException;
    void LowDamage(float persents);
    void ReflectDamage(int Damage, float persents);
    void EnableRegeneration();
    */
}
