package com.example.backeventplanner.service.person;

import com.example.backeventplanner.persistence.person.Person;
import com.example.backeventplanner.persistence.person.PersonRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.security.core.parameters.P;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class PersonServiceImplTest {

    @Mock
    private PersonRepo personRepo;

//    @InjectMocks
    private PersonService personService;

    @BeforeEach
    private void setUp(){
        personService = new PersonServiceImpl(personRepo);
    }

    @Test
    public void whenUserNameIsUniqueReturnIsTrue(){
        String userName = "AAA";
        Person person = null;

        Mockito.when(personRepo.findByUserName(userName)).thenReturn(person);

        Boolean check = personService.checkedUserName(userName);

        Mockito.verify(personRepo,Mockito.times(1)).findByUserName(ArgumentMatchers.any(String.class));

        Assertions.assertTrue(check);
    }

}