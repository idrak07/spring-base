package com.genuinecoder.springserver.model.weapon;

import com.genuinecoder.springserver.controller.WeaponIssue;
import com.genuinecoder.springserver.controller.WeaponStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class WeaponService {

    @Autowired
    private WeaponRepository weaponRepository;

    @Autowired
    private IssuedWeaponsRepository issuedWeaponsRepository;

    public Weapon save(Weapon weapon) {
        return weaponRepository.save(weapon);
    }

    public boolean issueWeapon(WeaponIssue weaponIssue) throws WeaponAssignedException, WeaponNotFoundException {
        Weapon weapon = weaponRepository.findById(weaponIssue.getWeaponId()).orElse(null);
        if(weapon != null) {
            if(!weapon.isAssigned()) {
                if(weaponRepository.findWeaponByAssignedTo(weaponIssue.getUserName()).isEmpty()) {
                    weapon.setAssigned(true);
                    weapon.setAssignedTo(weaponIssue.getUserName());
                    weaponRepository.save(weapon);

                    IssuedWeapons issuedWeapons = new IssuedWeapons();
                    issuedWeapons.setReason(weaponIssue.getReason());
                    issuedWeapons.setUserName(weaponIssue.getUserName());
                    issuedWeapons.setWeaponType(weapon.getWeaponType());
                    issuedWeapons.setWeaponName(weapon.getWeaponName());
                    issuedWeapons.setWeaponId(weapon.getId());
                    issuedWeapons.setButtNo(weapon.getButtNo());
                    issuedWeapons.setIssuedTime(Instant.now());

                    issuedWeaponsRepository.save(issuedWeapons);
                    return true;
                } else {
                    throw new WeaponAssignedException("User already has one assigned weapon");
                }
            } else {
                throw new WeaponAssignedException("Weapon is already assigned");
            }
        } else {
            throw new WeaponNotFoundException("Weapon not found");
        }
    }

    public boolean depositWeapon(WeaponIssue weaponIssue) throws WeaponNotFoundException {
        Weapon weapon = weaponRepository.findById(weaponIssue.getWeaponId()).orElse(null);
        if(weapon != null) {
            weapon.setAssignedTo(null);
            weapon.setAssigned(false);
            weaponRepository.save(weapon);
            List<IssuedWeapons> issuedWeapons = issuedWeaponsRepository.findByWeaponId(weaponIssue.getWeaponId());
            IssuedWeapons issuedWeapon = issuedWeapons.get(issuedWeapons.size() - 1);
            issuedWeapon.setDepositeTime(Instant.now());
            issuedWeaponsRepository.save(issuedWeapon);
            return true;
        } else {
            throw new WeaponNotFoundException("Weapon not found");
        }
    }

    public WeaponStatus getReport() {
        WeaponStatus weaponStatus = new WeaponStatus();
        weaponStatus.setFree(weaponRepository.getFree());
        weaponStatus.setAssigned(weaponRepository.getassigned());
        return weaponStatus;
    }

    public List<IssuedWeapons> getIssuedWeapon() {
        return issuedWeaponsRepository.findAll();
    }
}
