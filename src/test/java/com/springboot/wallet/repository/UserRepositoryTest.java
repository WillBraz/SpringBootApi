package com.springboot.wallet.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * UserRepositoryTest
 */

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserRepositoryTest {

    private static final String EMAIL = "willianlpbraz@gmail.com";

    @Autowired
    private UserRepository userRepository;


    @Before
    public void setUp(){
        
            testSave();
    }

    @After
    public void tearDown(){

        userRepository.deleteAll();
    }

    @Test
    public void testSave(){

        User user = new User();

        user.setName("Willian");
        user.setPassword("will");
        user.setEmail(EMAIL);

        userRepository.save(user);

        

    }

    public void testFindByEmail(){

       Optional<User> response  =  userRepository.findByEmail(EMAIL);

       assertTrue(response.isPresent());

       assertEquals(response.get().getEmail(), EMAIL);
    }
}