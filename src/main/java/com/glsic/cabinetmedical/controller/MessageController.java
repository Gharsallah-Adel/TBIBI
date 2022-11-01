package com.glsic.cabinetmedical.controller;

import com.glsic.cabinetmedical.entities.Message;
import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.repositories.MessageRepository;
import com.glsic.cabinetmedical.repositories.UserRepository;
import com.glsic.cabinetmedical.services.MessageService;
import com.glsic.cabinetmedical.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/MESSAGE")
public class MessageController {

    @Autowired
    MessageService messageService;

    @PostMapping("/addMessage")

    public Message addMessage(@RequestBody Message message) {
        return messageService.addMessage(message);


    }

    @GetMapping("/AllMessages")
    public List<Message> retrieveAllMessages() {
        List<Message> list = messageService.getAllMessage();
        return list;

    }

    @GetMapping("/byid/{user_id}")
    public Optional<Message> getById(@PathVariable("message_id") Long message_id) {
        Optional<Message> list = messageService.getById(message_id);
        return list;

    }

    @DeleteMapping("/remove-Message/{message_id}")
    public void removeMessage(@PathVariable("message_id") Long message_id) {
        messageService.deleteMessageById(message_id);
    }
    @PutMapping("/modify-Message/{message_id}")
    public Message modifyMessage(@RequestBody Message message,@PathVariable("message_id")Long message_id) {
        return messageService.updateMessage(message, message_id);
    }




}


