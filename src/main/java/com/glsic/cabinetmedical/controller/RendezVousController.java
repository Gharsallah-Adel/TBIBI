package com.glsic.cabinetmedical.controller;

import com.glsic.cabinetmedical.entities.RendezVous;
import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.repositories.RendezVousRepository;
import com.glsic.cabinetmedical.repositories.UserRepository;
import com.glsic.cabinetmedical.services.RendezVousService;
import com.glsic.cabinetmedical.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/RENDEZVOUZ")
public class RendezVousController {


    @Autowired
    RendezVousRepository rendezVousRepository;
    @Autowired
    RendezVousService rendezVousService;

    @PostMapping("/addRendezVous")
    public RendezVous addRendezVous(@RequestBody RendezVous rendezVous) {
        return rendezVousService.addRendezVous(rendezVous);


    }

    @GetMapping("/AllRendezsVous")
    public List<RendezVous> retrieveAllRendezsVous() {
        List<RendezVous> list = rendezVousService.getAllRendezVous();
        return list;

    }

    @GetMapping("/byid/{rendezVous_id}")
    public Optional<RendezVous> getById(@PathVariable("rendezVous_id") Long rendezVous_id) {
        Optional<RendezVous> list = rendezVousService.getById(rendezVous_id);
        return list;

    }

    @DeleteMapping("/remove-RV/{rendezVous_id}")
    public void removeRendezVous(@PathVariable("rendezVous_id") Long rendezVous_id) {
       rendezVousService.deleteRendezVousById(rendezVous_id);

    }
    @PutMapping("/modify-RV/{rendezVous_id}")
    public RendezVous modifyRedezVous(@RequestBody RendezVous rendezVous,@PathVariable("rendezVous_id")Long rendezVous_id) {
        return rendezVousService.updateRendezVous(rendezVous, rendezVous_id);
    }




}
