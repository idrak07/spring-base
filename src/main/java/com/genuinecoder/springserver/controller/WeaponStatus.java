package com.genuinecoder.springserver.controller;

public class WeaponStatus {
    private Long free;
    private Long assigned;

    public Long getFree() {
        return free;
    }

    public void setFree(Long free) {
        this.free = free;
    }

    public Long getAssigned() {
        return assigned;
    }

    public void setAssigned(Long assigned) {
        this.assigned = assigned;
    }
}
