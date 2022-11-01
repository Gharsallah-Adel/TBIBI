package com.glsic.cabinetmedical.controller;

import com.glsic.cabinetmedical.entities.DossierMedical;
import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.services.DossierMedicalService;
import com.glsic.cabinetmedical.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(path = "/DOSSIER")
public class DossierMedicalRestController {

    @Autowired
    DossierMedicalService dossierMedicalService;

    @PostMapping("/addDossier")
    public DossierMedical addUser(@RequestBody DossierMedical dossierMedical) {
        return dossierMedicalService.addDossierMedicale(dossierMedical);


    }

    @GetMapping("/AllDossiers")
    public List<DossierMedical> retrieveAllDossiers(){
        List<DossierMedical> list = dossierMedicalService.getAllDossiers();
        return list;

    }

    @GetMapping("/byid/{dossier_id}")
    public Optional<DossierMedical> getById(@PathVariable("dossier_id") Long dossier_id) {
        Optional<DossierMedical> list = dossierMedicalService.getById(dossier_id);
        return list;

    }

    @DeleteMapping("/remove-Dossier/{dossier_id}")
    public void removeUser(@PathVariable("dossier_id") Long dossier_id) {
        dossierMedicalService.deleteDossierById(dossier_id);

    }
    @PutMapping("/modify-Dossier/{dossier_id}")
    public DossierMedical modifyFurniture(@RequestBody DossierMedical dossierMedical,@PathVariable("dossier_id")Long dossier_id) {
        return dossierMedicalService.updateDossier(dossierMedical, dossier_id);
    }




}
