package com.glsic.cabinetmedical.controller;

import com.glsic.cabinetmedical.entities.Reclamation;
import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.repositories.UserRepository;
import com.glsic.cabinetmedical.services.ReclamationService;
import com.glsic.cabinetmedical.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/RECLAMATION")
public class ReclamationController {

    @Autowired
    ReclamationService reclamationService;

    @PostMapping("/addReclamation")
    public Reclamation addReclamation(@RequestBody Reclamation reclamation) {
        return reclamationService.addReclamation(reclamation);


    }

    @GetMapping("/AllReclamation")
    public List<Reclamation> retrieveAllUsers() {
        List<Reclamation> list = reclamationService.getAllReclamation();
        return list;

    }

    @GetMapping("/byid/{reclamation_id}")
    public Optional<Reclamation> getById(@PathVariable("reclamation_id") Long reclamation_id) {
        Optional<Reclamation> list = reclamationService.getById(reclamation_id);
        return list;

    }

    @DeleteMapping("/remove-Reclamation/{reclamation_id}")
    public void removeReclamation(@PathVariable("reclamation_id") Long reclamation_id) {
        reclamationService.deleteReclamationById(reclamation_id);

    }
    @PutMapping("/modify-Reclamation/{reclamation_id}")
    public Reclamation modifyReclamation(@RequestBody Reclamation reclamation,@PathVariable("reclamation_id")Long reclamation_id) {
        return reclamationService.updateReclamation(reclamation, reclamation_id);
    }




}
