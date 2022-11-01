package com.glsic.cabinetmedical.repositories;

import com.glsic.cabinetmedical.entities.DossierMedical;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierMedicalRepository extends CrudRepository<DossierMedical,Long> {



}
