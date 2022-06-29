package com.genuinecoder.springserver.model.weapon;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    public Weapon save(Weapon weapon) {
        return weaponRepository.save(weapon);
    }
}
