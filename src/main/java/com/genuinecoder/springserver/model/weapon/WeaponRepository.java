package com.genuinecoder.springserver.model.weapon;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WeaponRepository extends CrudRepository<Weapon, Long> {
    public List<Weapon> findWeaponByAssignedTo(String assignedTo);

    @Query(value = "select count(w.id)from weapon as w where assigned_to is NULL", nativeQuery = true)
    Long getFree();

    @Query(value = "select count(w.id)from weapon as w where assigned_to is NOT NULL", nativeQuery = true)
    Long getassigned();
}
