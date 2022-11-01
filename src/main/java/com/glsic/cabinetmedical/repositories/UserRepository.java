package com.glsic.cabinetmedical.repositories;

import com.glsic.cabinetmedical.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

   User findByUsername(String username);
    Optional<User>  findByEmail(String email);

}
