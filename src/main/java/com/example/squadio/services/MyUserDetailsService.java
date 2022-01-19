package com.example.squadio.services;

import com.example.squadio.entities.Authentication;
import com.example.squadio.repositories.AuthenticationRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author bkariuki
 */
@Service("userDetails")
public class MyUserDetailsService implements UserDetailsService {

    private final AuthenticationRepository authenticationRepository;

    public MyUserDetailsService(AuthenticationRepository authenticationRepository) {
        this.authenticationRepository = authenticationRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Authentication user = authenticationRepository.findByUsername(username);

        if (user == null) {
            throw new UsernameNotFoundException("user not found with provided username " + username);
        }
        return user;
    }
}
