package com.glsic.cabinetmedical.services;

import com.glsic.cabinetmedical.Request.LoginForm;
import com.glsic.cabinetmedical.Request.SignUpForm;
import com.glsic.cabinetmedical.Responce.SignInResponse;
import com.glsic.cabinetmedical.Utils.ErrorModel;
import com.glsic.cabinetmedical.entities.Role;
import com.glsic.cabinetmedical.entities.RoleName;
import com.glsic.cabinetmedical.entities.User;
import com.glsic.cabinetmedical.repositories.RoleNameRepository;
import com.glsic.cabinetmedical.repositories.UserRepository;
import com.glsic.cabinetmedical.security.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Configuration
public class UserService {
    //Post
    @Autowired
    RoleNameRepository roleNameRepository ;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtUtils jwtUtils ;

    @Autowired

    UserRepository userRepository;

    public User addUser(User user) {

        return userRepository.save(user);
    }

    //Get
    public List<User> getAllUser() {

        return (List<User>) userRepository.findAll();
    }

    //get by id

    public Optional<User> getById(int id) {

        return (Optional<User>) userRepository.findById(id);
    }

    // delete
    public void deleteUserById(int user_id) {
        userRepository.delete(userRepository.findById(user_id).get());

    }

    //Update
    public User updateUser(User user, int user_id) {
        User us = userRepository.findById(user_id).get();

        user.setUser_id(us.getUser_id());

        userRepository.save(user);
        return user;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    public ResponseEntity<?> signUp(SignUpForm signUpForm) {
        String role = signUpForm.getRole();

        if (userRepository.findByUsername(signUpForm.getUsername())!=null) {
            return new ResponseEntity<>(new ErrorModel("user name is used"), HttpStatus.BAD_REQUEST);
        }
        if (userRepository.findByEmail(signUpForm.getEmail()).isPresent()) {
            return new ResponseEntity<>(new ErrorModel(" Email is  used"), HttpStatus.BAD_REQUEST);
        }
        if (!isValidEmailAddress(signUpForm.getEmail())) {
            return new ResponseEntity<>(new ErrorModel("Invalid email"), HttpStatus.BAD_REQUEST);
        }


        User user = new User();
        user.setFirstName(signUpForm.getFirstName());
        user.setLastName(signUpForm.getLastName());
        user.setAddress(signUpForm.getAddress());
        user.setEmail(signUpForm.getEmail());
        LocalDate today = LocalDate.now();
        user.setDate_Creation(today);
        user.setPhone(signUpForm.getPhone());
        user.setGender(signUpForm.getGender());
        user.setUsername(signUpForm.getUsername());
        String password = passwordEncoder().encode(signUpForm.getPassword());
        user.setPassword(password);
        List<RoleName> rolesNameList = new ArrayList<>();
        rolesNameList.add(roleNameRepository.findByName(role).get());
        user.setRole_name(rolesNameList);
        user.setSituationFamilial(signUpForm.getSituationFamilial());
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);


    }

    public ResponseEntity<?> signIn ( LoginForm loginform) {

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginform.getUsername(), loginform.getPassword()));


        String jwt = jwtUtils.generateToken(loginform.getUsername());
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();

        return new ResponseEntity<>(new SignInResponse(jwt, userDetails.getUsername(), userDetails.getAuthorities()),HttpStatus.ACCEPTED);
    }





    public boolean isValidEmailAddress(String email) {
        String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
        java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
        java.util.regex.Matcher m = p.matcher(email);
        return m.matches();
    }

}

