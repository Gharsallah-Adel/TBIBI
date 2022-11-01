package com.glsic.cabinetmedical.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message  implements Serializable {
    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long message_id;

    private String contenuMessage;
    private Date dateMessage;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return Objects.equals(message_id, message.message_id) && Objects.equals(contenuMessage, message.contenuMessage) && Objects.equals(dateMessage, message.dateMessage) && Objects.equals(user, message.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(message_id, contenuMessage, dateMessage, user);
    }

    public Long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(Long message_id) {
        this.message_id = message_id;
    }

    @Override
    public String toString() {
        return "Message{" +
                "message_id=" + message_id +
                ", contenuMessage='" + contenuMessage + '\'' +
                ", dateMessage=" + dateMessage +
                ", user=" + user +
                '}';
    }

    @ManyToOne(cascade = CascadeType.PERSIST)
   @JoinColumn(name = "user_id")
    private User user;

}
