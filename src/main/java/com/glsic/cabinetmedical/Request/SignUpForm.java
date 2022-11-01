package com.glsic.cabinetmedical.Request;

import lombok.Data;

@Data
public class SignUpForm {


    private Long user_id;

    private String username;

    private String password;

    private String firstName;

    private String lastName;

    private String email;


    private String gender;

    private  Integer age;

    private  Integer phone;

    private  String address;

    private  String situationFamilial;

    private String Role ;



}
