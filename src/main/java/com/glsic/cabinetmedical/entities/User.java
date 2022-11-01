package com.glsic.cabinetmedical.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NaturalId;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {


    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private int user_id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;

    private String gender;

    private  Integer age;

    private  Integer phone;

    private LocalDate date_Creation ;

    private  String address;

    private  String situationFamilial;


    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<RendezVous> rendezVous;

 @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
  private List<Message> messages;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY)
    private List<Reclamation> reclamations;

@OneToOne(cascade = CascadeType.ALL)
   @JoinColumn(name = "user_dossier", referencedColumnName = "dossier_id")
   private DossierMedical dossierMedical;

    @Enumerated(EnumType.STRING)
    @NaturalId
    @ManyToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "id"),
            inverseJoinColumns = @JoinColumn(name = "id_role"))
    private List<RoleName> role_name = new ArrayList<RoleName>();

}
