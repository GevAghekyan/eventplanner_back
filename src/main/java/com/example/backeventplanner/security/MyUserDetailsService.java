package com.example.backeventplanner.security;

import com.example.backeventplanner.persistence.person.Person;
import com.example.backeventplanner.persistence.person.PersonRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private PersonRepo personRepo;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        Optional<Person> user = Optional.of(personRepo.findByUserName(userName));

        user.orElseThrow(() -> new UsernameNotFoundException("Not found : " + userName));
        Person person = user.get();

        return new MyUserDetails(person);
    }
}
