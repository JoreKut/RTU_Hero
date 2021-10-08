package com.company.Items.Armors;

import com.company.Items.ArmorType;
import com.company.Items.Item;

public class Armor extends Item implements Protectable {
    public int Health;
    public ArmorType armorType;

    public Armor(ArmorType armorType){
        this.Health = 100;
        this.armorType = armorType;
        System.out.println("ARMOR HAS CREATED. " + this.armorType + " HP:" + this.Health + "\n\n\n");
    }

    public int TakeDamage(int Damage) {

        if(this.Health != 0){
            this.Health -= Damage;
            System.out.println("Shoot to " + this.armorType + " | ARMOR HP:" + this.Health);
            if(this.Health < 0) {
                this.Health = 0;
                System.out.println(this.Name + "-ARMOR is broken ...");
            }
            return 0;
        }

        return Damage;
    }

    @Override
    public void UseDefenceSuperPower() {

    }

    @Override
    public String toString() {
        return "Armor{" +
                "Health=" + Health +
                ", armorType=" + armorType +
                ", Name='" + Name + '\'' +
                ", Level=" + Level +
                ", AccessLevel=" + AccessLevel +
                ", Price=" + Price +
                ", power=" + power +
                '}';
    }
}
