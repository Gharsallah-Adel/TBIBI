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
public class Reclamation implements Serializable {


    private static final Long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  reclamation_id;

    private String contenu_rec ;

    private Date date_reclamation ;

    @Override
    public String toString() {
        return "Reclamation{" +
                "reclamation_id=" + reclamation_id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Reclamation that = (Reclamation) o;
        return Objects.equals(reclamation_id, that.reclamation_id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reclamation_id);
    }

    public static Long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getReclamation_id() {
        return reclamation_id;
    }

    public void setReclamation_id(Long reclamation_id) {
        this.reclamation_id = reclamation_id;
    }


    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "user_id")
    private User user;

}
