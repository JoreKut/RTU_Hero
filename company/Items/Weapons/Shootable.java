package com.company.Items.Weapons;

import com.company.Characters.Character;

public interface Shootable {
    void ShootTo(Character ch);
    void ReLoad();
}
