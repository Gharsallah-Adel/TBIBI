package com.glsic.cabinetmedical.services;

import com.glsic.cabinetmedical.entities.Reclamation;
import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.repositories.ReclamationRepository;
import com.glsic.cabinetmedical.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

@Service
public class ReclamationService {

    @Autowired
    ReclamationRepository reclamationRepository;



    //Post
    public Reclamation addReclamation(Reclamation reclamation){


         reclamationRepository.save(reclamation);
        try {
            sendmail();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return reclamation;

    }
    //Get
    public List<Reclamation> getAllReclamation() {

        return (List<Reclamation>) reclamationRepository.findAll();
    }

    //get by id

    public Optional<Reclamation> getById(Long id) {

        return (Optional<Reclamation>) reclamationRepository.findById(id);
    }
    // delete
    public void deleteReclamationById(Long reclamation_id) {
        reclamationRepository.delete(reclamationRepository.findById(reclamation_id).get());

    }
    //Update
    public Reclamation updateReclamation( Reclamation reclamation, Long reclamation_id) {
        Reclamation rec=	reclamationRepository.findById(reclamation_id).get();

        reclamation.setReclamation_id(rec.getReclamation_id());

        reclamationRepository.save(reclamation);
        return reclamation;
    }

    private void sendmail() throws AddressException, MessagingException, IOException {

        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");

        Session session = Session.getInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("adel.gharsallah94@gmail.com" , "adel58866");


            }
        });

        Message msg = new MimeMessage(session);
        msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse("\n" + "m.bouguerba96@gmail.com"));
        msg.setSubject("Votre reclamation");
        msg.setContent("Tutorials point email", "text/html");
        msg.setSentDate(new Date());
        msg.setText("Bonjour docteur,"+ "\n" + "nous vous informe que vous avez reçu une nouvelle reclamation médicale .");
        Transport.send(msg);
    }
}





