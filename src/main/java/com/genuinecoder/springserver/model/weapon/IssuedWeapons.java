package com.genuinecoder.springserver.model.weapon;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.time.Instant;

@Entity
public class IssuedWeapons {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    private String reason;

    private String userName;

    private Long weaponId;

    @CreatedDate
    private Instant issuedTime;

    @LastModifiedDate
    private Instant depositeTime;

    private String weaponType;

    private String weaponName;

    private String buttNo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Long getWeaponId() {
        return weaponId;
    }

    public void setWeaponId(Long weaponId) {
        this.weaponId = weaponId;
    }

    public Instant getIssuedTime() {
        return issuedTime;
    }

    public void setIssuedTime(Instant issuedTime) {
        this.issuedTime = issuedTime;
    }

    public Instant getDepositeTime() {
        return depositeTime;
    }

    public void setDepositeTime(Instant depositeTime) {
        this.depositeTime = depositeTime;
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
}
