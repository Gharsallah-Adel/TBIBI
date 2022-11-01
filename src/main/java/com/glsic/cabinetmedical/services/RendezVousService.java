package com.glsic.cabinetmedical.services;

import com.glsic.cabinetmedical.entities.RendezVous;
import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.repositories.RendezVousRepository;
import com.glsic.cabinetmedical.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RendezVousService {

    //Post
    @Autowired
    RendezVousRepository rendezVousRepository;
    public RendezVous addRendezVous(RendezVous rendezVous){

        return rendezVousRepository.save(rendezVous);
    }
    //Get
    public List<RendezVous> getAllRendezVous() {

        return (List<RendezVous>) rendezVousRepository.findAll();
    }

    //get by id

    public Optional<RendezVous> getById(Long id) {

        return (Optional<RendezVous>) rendezVousRepository.findById(id);
    }
    // delete
    public void deleteRendezVousById(Long rendezVous_id) {
      rendezVousRepository.delete(rendezVousRepository.findById(rendezVous_id).get());

    }
    //Update
    public RendezVous updateRendezVous( RendezVous rendezVous, Long rendezVous_id) {
        RendezVous rv=	rendezVousRepository.findById(rendezVous_id).get();

        rendezVous.setRendezVous_id(rv.getRendezVous_id());

        rendezVousRepository.save(rendezVous);
        return rendezVous;
    }
}
