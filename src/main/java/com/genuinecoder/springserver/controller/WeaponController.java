package com.genuinecoder.springserver.controller;

import com.genuinecoder.springserver.model.employee.Employee;
import com.genuinecoder.springserver.model.weapon.Weapon;
import com.genuinecoder.springserver.model.weapon.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @PostMapping("/weapon")
    public Weapon save(@RequestBody Weapon weapon) {
        return weaponService.save(weapon);
    }
}
