package com.glsic.cabinetmedical.entities;

import org.hibernate.annotations.GeneratorType;
import org.hibernate.annotations.NaturalId;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
public class RoleName implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
 private int id;

    @Enumerated(EnumType.STRING)
    @NaturalId
    private Role name;











    @Override
    public String getAuthority() {
        return null;
    }

}
