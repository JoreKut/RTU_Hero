package com.company.Characters;

import com.company.Powers.Superpower;
import com.company.Items.Weapons.Weapon;

import java.util.ArrayList;
import java.util.Arrays;

public class Hero extends Character implements AliveCharacter, Runnable{

    protected int Experience;
    protected int Coins;
    protected int ManaPoints;

    protected int[] Loot;

    ArrayList<Superpower> SuperPowerList;
    ArrayList<Weapon> WeaponList;

    public Hero(String Name ){
        this.Name = Name;

        this.Health = 100;
        this.AttackDamage = 30;
        this.Level = 0;
        this.Experience = 0;
        this.Coins = 10;
        this.ManaPoints = 0;

    }

    public void StartFighting() {

        this.Fight = true;

        while(this.Fight && this.IsAlive()){
            ShootToEnemy();

            if(!this.Enemy.IsAlive()){
                GetLoot();
                this.WinnerMessage();
                this.Enemy.LoserMessage();
                this.Fight = false;
                this.Enemy.Die();

                System.out.println("Loot: " + Arrays.toString(this.Loot));
                System.out.println("Coins: " + this.Coins + " Experience: " + this.Experience + " Mana: " + this.ManaPoints);
            }

        }

    }

    @Override
    public void GetLoot() {
        int[] loot = Enemy.DropLoot();
        this.Coins += loot[0];
        this.Experience += loot[1];
        this.ManaPoints += loot[2];
    }

    @Override
    public int[] DropLoot() {
        return new int[0];
    }

    public void SetEnemyLoot(int[] Loot){
        this.Loot = Loot;
    }

    @Override
    public String toString() {
        return "Hero{" +
                "Fight=" + Fight +
                ", Health=" + Health +
                ", Damage=" + AttackDamage +
                ", superpower=" + defenseSP +
                ", weapon=" + weapon +
                ", Boots=" + Boots +
                ", Chestplate=" + Chestplate +
                ", Leggens=" + Leggens +
                ", Helmet=" + Helmet +
                ", Name='" + Name + '\'' +
                ", Level=" + Level +
                ", Experience=" + Experience +
                ", Coins=" + Coins +
                ", ManaPoints=" + ManaPoints +
                ", SuperPowerList=" + SuperPowerList +
                ", WeaponList=" + WeaponList +
                '}';
    }

}
