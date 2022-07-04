package com.genuinecoder.springserver.controller;

import com.genuinecoder.springserver.model.weapon.IssuedWeapons;
import com.genuinecoder.springserver.model.weapon.Weapon;
import com.genuinecoder.springserver.model.weapon.WeaponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class WeaponController {

    @Autowired
    private WeaponService weaponService;

    @PostMapping("/weapon")
    public Weapon save(@RequestBody Weapon weapon) {
        return weaponService.save(weapon);
    }

    @PostMapping("/weapon/issue")
    public ResponseEntity issueWeapon(@RequestBody WeaponIssue weaponIssue) throws BadRequestAlertException {
        try {
            if(weaponService.issueWeapon(weaponIssue)) {
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage());
        }
        return null;
    }

    @PostMapping("/weapon/deposit")
    public ResponseEntity depositWeapon(@RequestBody WeaponIssue weaponIssue) throws BadRequestAlertException {
        try {
            if(weaponService.depositWeapon(weaponIssue)) {
                return ResponseEntity.ok().build();
            }
        } catch (Exception e) {
            throw new BadRequestAlertException(e.getMessage());
        }
        return null;
    }
    @PostMapping("/weapon/report")
    public WeaponStatus getReport() {
        return weaponService.getReport();
    }

    @GetMapping("/weapon/issues")
    public List<IssuedWeapons> getIssuedWeapon() {
        return weaponService.getIssuedWeapon();
    }
}
