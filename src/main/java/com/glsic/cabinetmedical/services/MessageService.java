package com.glsic.cabinetmedical.services;

import com.glsic.cabinetmedical.entities.Message;
import com.glsic.cabinetmedical.entities.Reclamation;
import com.glsic.cabinetmedical.repositories.MessageRepository;
import com.glsic.cabinetmedical.repositories.ReclamationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    //Post
    @Autowired
    MessageRepository messageRepository;
    public Message addMessage(Message message){

        return messageRepository.save(message);
    }
    //Get
    public List<Message> getAllMessage() {

        return (List<Message>) messageRepository.findAll();
    }

    //get by id

    public Optional<Message> getById(Long id) {

        return (Optional<Message>) messageRepository.findById(id);
    }
    // delete
    public void deleteMessageById(Long message_id) {
        messageRepository.delete(messageRepository.findById(message_id).get());

    }
    //Update
    public Message updateMessage( Message message, Long message_id) {
        Message mes=	messageRepository.findById(message_id).get();

        message.setMessage_id(mes.getMessage_id());

        messageRepository.save(message);
        return message;
    }
}


