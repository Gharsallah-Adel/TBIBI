package com.glsic.cabinetmedical.repositories;

import com.glsic.cabinetmedical.entities.Reclamation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReclamationRepository extends CrudRepository<Reclamation,Long> {

}
