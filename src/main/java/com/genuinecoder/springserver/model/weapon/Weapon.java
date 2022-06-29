package com.genuinecoder.springserver.model.weapon;

import java.io.Serializable;
import javax.persistence.*;

@Entity
public class Weapon implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private Long id;

    private String weaponType;

    private String weaponName;

    private String buttNo;

    private Long assignedTo;

    private boolean isAssigned = Boolean.FALSE;

    public Weapon() {}

    public Weapon(Long id, String weaponType, String weaponName, String buttNo, Long assignedTo, boolean isAssigned) {
        this.id = id;
        this.weaponType = weaponType;
        this.weaponName = weaponName;
        this.buttNo = buttNo;
        this.assignedTo = assignedTo;
        this.isAssigned = isAssigned;
    }

    public Weapon(Long id, String weaponType, String weaponName, String buttNo) {
        this.id = id;
        this.weaponType = weaponType;
        this.weaponName = weaponName;
        this.buttNo = buttNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        this.weaponType = weaponType;
    }

    public String getWeaponName() {
        return weaponName;
    }

    public void setWeaponName(String weaponName) {
        this.weaponName = weaponName;
    }

    public String getButtNo() {
        return buttNo;
    }

    public void setButtNo(String buttNo) {
        this.buttNo = buttNo;
    }

    public Long getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Long assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isAssigned() {
        return isAssigned;
    }

    public void setAssigned(boolean assigned) {
        isAssigned = assigned;
    }

    @Override
    public String toString() {
        return (
                "Weapon{" +
                        "id=" +
                        id +
                        ", weaponType='" +
                        weaponType +
                        '\'' +
                        ", weaponName='" +
                        weaponName +
                        '\'' +
                        ", buttNo='" +
                        buttNo +
                        '\'' +
                        ", assignedTo=" +
                        assignedTo +
                        ", isAssigned=" +
                        isAssigned +
                        '}'
        );
    }
}

