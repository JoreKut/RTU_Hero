package com.company;


import com.company.Characters.Enemy;
import com.company.Characters.Hero;
import com.company.Items.Armors.Armor;
import com.company.Items.ArmorType;
import com.company.Items.Weapons.Shootable;
import com.company.Items.Weapons.Weapon;
import com.company.Powers.Attackes.Attackable;
import com.company.Powers.Attackes.FreezeSP;
import com.company.Powers.Attackes.RageSP;
import com.company.Powers.Defenses.Defensable;
import com.company.Powers.Defenses.SpikeSP;
import com.company.Powers.Defenses.StoneSP;
import com.company.UI.MainApp;

public class Main {

    public static void S(Runnable r){

    }

    public static void main(String[] args) throws InterruptedException {


        Shootable w = new Weapon("AK-47",10,1, 100,1,1);
        Shootable w2 = new Weapon("Bow",7,1,100,1,1);

        Armor helmet = new Armor(ArmorType.HELMET);

        Attackable a = new RageSP(5, 50);

        Hero h1 = new Hero("Jack");
        Enemy en = new Enemy("Goblin",2,2,2,70);


        h1.SetEnemy(en);


        h1.SetWeapon(w);
        h1.SetAttackSuperPower(a);
        h1.SetEnemyLoot(en.DropLoot());

        en.SetEnemy(h1);
        en.SetWeapon(w2);
        en.SetArmor(helmet);


        Thread HeroThread = new Thread(h1);
        Thread EnemyThread = new Thread(en);

        HeroThread.start();
        EnemyThread.start();


/*
        MainApp window = new MainApp();
        window.LoadMenu();
*/
    }

}
