package com.glsic.cabinetmedical.services;

        import com.glsic.cabinetmedical.entities.User;
        import com.glsic.cabinetmedical.repositories.UserRepository;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.security.core.authority.AuthorityUtils;
        import org.springframework.security.core.userdetails.UserDetails;
        import org.springframework.security.core.userdetails.UserDetailsService;
        import org.springframework.security.core.userdetails.UsernameNotFoundException;
        import org.springframework.stereotype.Service;


        import java.util.Optional;

@Service
public class                 MyUserDetailsService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User userOptional=userRepository.findByUsername(username);

        if (userOptional==null)
            throw new UsernameNotFoundException("User not exist with name :" +username);
        String pass=userOptional.getPassword();


        return new org.springframework.security.core.userdetails.User (username,pass, userOptional.getRole_name());

    }

}