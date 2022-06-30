package com.genuinecoder.springserver.model.weapon;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IssuedWeaponsRepository extends CrudRepository<IssuedWeapons, Long> {
    List<IssuedWeapons> findByWeaponId(Long weaponId);
}
