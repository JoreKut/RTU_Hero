package com.company.Characters;


public class Enemy extends Character implements AliveCharacter, Runnable{

    protected int EarnedCoins;
    protected int EarnedExperience;
    protected int EarnedManaPoints;


    public Enemy(String Name, int EarnedCoins, int EarnedExperience, int EarnedManaPoints, int Health){
        this.Name = Name;
        this.EarnedCoins = EarnedCoins;
        this.EarnedExperience = EarnedExperience;
        this.EarnedManaPoints = EarnedManaPoints;
        this.Health = Health;
    }


    public boolean IsAlive() {
        return this.Health > 0;
    }

    public int[] DropLoot(){

        return new int[]{
                this.EarnedCoins,
                this.EarnedExperience,
                this.EarnedManaPoints
        };

    }

    public void StartFighting() {

        this.Fight = true;

        while (this.Fight && this.IsAlive()) {

            ShootToEnemy();

            if (!this.Enemy.IsAlive()) {
                this.WinnerMessage();
                this.Enemy.LoserMessage();
                this.Enemy.Die();
                this.Fight = false;
            }

        }
    }

    @Override
    public void GetLoot() {

    }

}
