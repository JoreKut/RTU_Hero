package com.company.Characters;


import com.company.*;
import com.company.Items.Armors.Armor;
import com.company.Items.ArmorType;
import com.company.Items.Armors.Protectable;
import com.company.Items.Weapons.Shootable;
import com.company.Powers.Attackes.Attackable;
import com.company.Powers.Defenses.Defensable;
import com.company.Powers.Globals.Globable;

public class Character extends GameObject implements AliveCharacter, Powerable, Runnable {

    protected AliveCharacter Enemy;


    protected boolean Fight;

    public float Health;
    protected int AttackDamage;
    protected int StartAttackDamage;
    protected int ReceivedDamage;

    protected Defensable defenseSP;
    protected Attackable attackSP;
    protected Globable globalSP;

    protected Shootable weapon;

    protected Protectable Boots;
    protected Protectable Chestplate;
    protected Protectable Leggens;
    protected Protectable Helmet;


    @Override
    public boolean IsAlive() {return this.Health > 0;}

    @Override
    public void ShootToEnemy() {

        System.out.println("\n\n" + this.Name + " shooted");
        //
        // USING SUPERPOWERS AND ECT HERE
        //
        if(attackSP != null) {
            System.out.println("\nTYING TO USE SUPERPOWER");
            try {
                attackSP.UseAttackPower(this);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("\n");
        }

        this.weapon.ShootTo((Character) this.Enemy);
        this.weapon.ReLoad();

        System.out.println("\n\n");
    }

    @Override
    public void GetDamage(int Damage, ArmorType type){

        this.ReceivedDamage = Damage;

        System.out.println("GET_DAMAGE Function :" + Damage);
        // USING SUPERPOWER
        if(defenseSP != null) {
            System.out.println("\nTYING TO USE SUPERPOWER");
            defenseSP.UseDefensePower(this);
            System.out.println("\n");
        }

        switch (type){
            case BOOTS: {
                if (this.Boots != null){
                    this.Health -= this.Boots.TakeDamage((int) (this.ReceivedDamage * 0.3));
                }
                else{
                    this.Health -= this.ReceivedDamage;
                }
            }
            case LEGGENS: {
                if (this.Leggens != null){
                    this.Health -= this.Leggens.TakeDamage((int)(this.ReceivedDamage * 0.6))  ;
                }
                else{
                    this.Health -= this.ReceivedDamage;
                }
            }
            case CHESTPLATE:{
                if (this.Chestplate != null){
                    this.Health -= this.Chestplate.TakeDamage((int)(this.ReceivedDamage * 1.0));
                }
                else{
                    this.Health -= this.ReceivedDamage;
                }
            }
            case HELMET:{
                if (this.Helmet != null){
                    this.Health -= this.Helmet.TakeDamage((int)(this.ReceivedDamage * 1.4));
                }
                else{
                    this.Health -= this.ReceivedDamage;
                }
            }
        }

        if(this.Health < 0 ) this.Health = 0;



    }

    @Override
    public void StartFighting() {

    }

    public void SetEnemy(Character Enemy) {
        this.Enemy = Enemy;
    }

    public void SetWeapon(Shootable weapon) {
        this.weapon = weapon;
    }

    public void SetArmor(Armor armor) {
        switch (armor.armorType){
            case BOOTS -> this.Boots = armor;
            case LEGGENS -> this.Leggens = armor;
            case CHESTPLATE -> this.Chestplate = armor;
            case HELMET -> this.Helmet = armor;
        }

    }

    public void SetDefenseSuperPower(Defensable superpower) {
        this.defenseSP = superpower;
    }

    public void SetAttackSuperPower(Attackable superpower) {
        this.attackSP = superpower;
    }

    public void WinnerMessage() {
        System.out.println(this.Name + ": \"Ha-ha-ha-ha ! This moment has come ! I WON you !\"");
    }

    public void LoserMessage() {
        System.out.println(this.Name + ": \"No, noway !!! NO-WAY!!! This can't be true... I will be back !!!!\n");
    }

    public void Die() {
        this.Fight = false;
        Thread.currentThread().interrupt();
    }

    @Override
    public void GetLoot() {

    }

    @Override
    public int[] DropLoot() {
        return new int[0];
    }

    @Override
    public void LowCurEnemyDamage(int percents) {
        this.ReceivedDamage *= (100 - percents/100);
    }

    @Override
    public void ReflectEnemyDamage(int percents) {
        System.out.println("!!!!!  Reflect");
        this.Enemy.GetDamage((int)(this.ReceivedDamage *percents/100), ArmorType.CHESTPLATE);
        System.out.println("-----  Reflect");
    }

    @Override
    public void PoisonHit(int time, int damagePerSecond) {

    }

    @Override
    public void FreezeEnemy(int time) throws InterruptedException {
        this.Enemy.Freeze(time);
    }

    public void Freeze(int time) throws InterruptedException{
        System.out.println(this.Name + " thread is Freezed");
        Thread.sleep(time*1000L);
    }

    @Override
    public void RageMode(int minHealth, int percentOfAttackDamage) {
        if(this.Health < (int)(this.StartAttackDamage*minHealth/100)){
            this.AttackDamage *= (int)((100 + percentOfAttackDamage)/100);
        }
    }

    @Override
    public void run() {
        System.out.println(this.Name + " has started...");
        StartFighting();
    }


    //----------------SUPERPOWER's METHODS-------------------------
    /*

    @Override
    public void LowEnemyDamage(float persents) {
        this.Damage *= (1 - persents);
    }

    @Override
    public void Freeze(int time){
        System.out.println("FREEZE HAS STARTED");
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("FREEZE HAS ENDED");
    }

    @Override
    public void ReflectDamage(int Damage, float persents) {
        this.Enemy.GetDamage((int)(Damage*persents), ArmorType.CHESTPLATE);
    }

    @Override
    public void EnableRegeneration() {
        // NOT ALL AN ONCE ;)
    }
*/
}
