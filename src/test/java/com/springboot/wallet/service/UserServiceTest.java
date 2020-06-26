package com.springboot.wallet.service;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import com.springboot.entity.User;
import com.springboot.repository.UserRepository;
import com.springboot.service.UserService;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class UserServiceTest {

    @MockBean
    UserRepository userRepository;

    @Autowired
    UserService userService;
    
    @Before
    public void setUp() {

        BDDMockito.given(userRepository.findByEmail(Mockito.anyString())).willReturn(Optional.of(new User()));
    }

    @Test
    public void testFindByEmail() {

        Optional<User> user  = userService.findByEmail("teste@mail.com");

        assertTrue(user.isPresent());
    }
}