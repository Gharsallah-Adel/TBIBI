package com.glsic.cabinetmedical.services;

import com.glsic.cabinetmedical.entities.DossierMedical;
import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.repositories.DossierMedicalRepository;
import com.glsic.cabinetmedical.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DossierMedicalService {
    @Autowired
    DossierMedicalRepository dossierMedicalRepository;

    public DossierMedical addDossierMedicale(DossierMedical dossierMedical){

        return dossierMedicalRepository.save(dossierMedical);
    }
    //Get
    public List<DossierMedical> getAllDossiers() {

        return (List<DossierMedical>) dossierMedicalRepository.findAll();
    }

    //get by id

    public Optional<DossierMedical> getById(Long id) {

        return (Optional<DossierMedical>) dossierMedicalRepository.findById(id);
    }
    // delete
    public void deleteDossierById(Long dossier_id) {
        dossierMedicalRepository.delete(dossierMedicalRepository.findById(dossier_id).get());

    }
    //Update
    public DossierMedical updateDossier( DossierMedical dossierMedical, Long dossier_id) {
        DossierMedical ds=	dossierMedicalRepository.findById(dossier_id).get();

        dossierMedical.setDossier_id(ds.getDossier_id());

        dossierMedicalRepository.save(dossierMedical);
        return dossierMedical;
    }
}


