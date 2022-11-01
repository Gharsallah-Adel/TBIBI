package com.glsic.cabinetmedical.repositories;

import com.glsic.cabinetmedical.entities.Role;
import com.glsic.cabinetmedical.entities.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoleNameRepository extends JpaRepository<RoleName,Integer> {

    Optional<RoleName> findByName(String name);


}
