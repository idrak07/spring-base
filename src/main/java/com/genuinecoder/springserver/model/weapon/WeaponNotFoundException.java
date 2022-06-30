package com.genuinecoder.springserver.model.weapon;

public class WeaponNotFoundException extends Exception {
    public WeaponNotFoundException(String message) {
        super(message);
    }
}
