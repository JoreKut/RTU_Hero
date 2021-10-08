package com.company.Items.Weapons;

import com.company.Characters.Character;
import com.company.Items.ArmorType;
import com.company.Items.Item;
import com.company.Powers.Superpower;

import java.util.Random;

public class Weapon extends Item implements Shootable {

    public int Damage;
    public int ReLoadDelay;
    public Superpower superpower;

    public Weapon(String name, int Damage, int ReLoadDelay, int Price, int Level, int AccessLevel){
        this.Damage = Damage;
        this.ReLoadDelay = ReLoadDelay;
        this.Name = name;
        this.Price = Price;
        this.Level = Level;
        this.AccessLevel = AccessLevel;
    }

    private ArmorType RandomArea(){
        ArmorType type;
        Random r = new Random();
        int ch = r.nextInt(100);
        if(ch <= 5){
            type = ArmorType.HELMET;
        }
        else if(ch<15){
            type = ArmorType.BOOTS;
        }
        else if(ch <30){
            type = ArmorType.LEGGENS;
        }
        else{
            type = ArmorType.CHESTPLATE;
        }

        return type;

    }

    public void ShootTo(Character ch){
        //
        //  CHOOSE THE AREA OF THE DAMAGE (BOOTS, LEGGENS, CHESTPLATE, HELMET)
        //
        ArmorType at = RandomArea();
        ch.GetDamage(this.Damage, at);
        System.out.println(this.Name + "-weapon with damage = " + this.Damage + " to " + at + " | " + ch.Name + " HP:" + ch.Health);

    }

    public void ReLoad(){
        System.out.println("Reloading... (" + this.ReLoadDelay + "sec)");
        try {
            Thread.sleep((int)this.ReLoadDelay*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void SetSuperPower(Superpower superpower){
        this.superpower = superpower;
    }

    @Override
    public String toString() {
        return "Weapon{" +
                "Name='" + Name + '\'' +
                ", Level=" + Level +
                ", AccessLevel=" + AccessLevel +
                ", Price=" + Price +
                ", power=" + power +
                ", Damage=" + Damage +
                ", ReLoadDelay=" + ReLoadDelay +
                ", superpower=" + superpower +
                '}';
    }
}














