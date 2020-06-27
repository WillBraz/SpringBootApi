package com.springboot.wallet.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.dto.UserDTO;
import com.springboot.entity.User;
import com.springboot.service.UserService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {

    private static final String EMAIL = "teste@email.com";
    private static final String NAME = "willian";
    private static final String PASSAWORD = "123456";
    private static final String URL = "/user";

    @MockBean
    UserService userService;

    @Autowired
    MockMvc mockMvc;

    @Test
    public void testSave() throws Exception {

        BDDMockito.given(userService.save(Mockito.any(User.class))).willReturn(getMockUser());

        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload())
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .accept(org.springframework.http.MediaType.APPLICATION_JSON)).andExpect(status().isCreated());

    }

    public User getMockUser() {

        User user = new User();
        user.setEmail(EMAIL);
        user.setName(NAME);
        user.setPassword(PASSAWORD);

        return user;
    }

    public String getJsonPayload() throws JsonProcessingException {

        UserDTO userDTO = new UserDTO();
        userDTO.setEmail(EMAIL);
        userDTO.setName(NAME);
        userDTO.setPassword(PASSAWORD);

        // Conversão object para retornar String
        ObjectMapper objMapper = new ObjectMapper();
       
        return objMapper.writeValueAsString(userDTO);


    }

}