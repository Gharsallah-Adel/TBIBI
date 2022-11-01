package com.glsic.cabinetmedical.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class RendezVous {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rendezVous_id;

    @Override
    public String toString() {
        return "RendezVous{" +
                "rendezVous_id=" + rendezVous_id +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RendezVous that = (RendezVous) o;
        return Objects.equals(rendezVous_id, that.rendezVous_id) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rendezVous_id, user);
    }

    public Long getRendezVous_id() {
        return rendezVous_id;
    }

    public void setRendezVous_id(Long rendezVous_id) {
        this.rendezVous_id = rendezVous_id;
    }

    @ManyToOne
    @JoinColumn(name="User_id", nullable=false)
    private User user;


}
