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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@AutoConfigureMockMvc
public class UserControllerTest {

    private static final Long ID = 1L;
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

        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(ID, EMAIL, NAME, PASSAWORD))
                .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
                .accept(org.springframework.http.MediaType.APPLICATION_JSON))
                     .andExpect(status().isCreated())
                     .andExpect(jsonPath("$.data.id").value(ID))
                     .andExpect(jsonPath("$.data.email").value(EMAIL))
                     .andExpect(jsonPath("$.data.name").value(NAME))
                     .andExpect(jsonPath("$.data.password").value(PASSAWORD));

    }

    @Test
    public void testSaveInvalidUser() throws JsonProcessingException, Exception {

        mockMvc.perform(MockMvcRequestBuilders.post(URL).content(getJsonPayload(ID, "email", NAME, PASSAWORD))
        .contentType(org.springframework.http.MediaType.APPLICATION_JSON)
        .accept(org.springframework.http.MediaType.APPLICATION_JSON))
             .andExpect(status().isBadRequest())
             .andExpect(jsonPath("$.errors[0]").value("Email inválido"));
           

    }

    public User getMockUser() {

        User user = new User();
        user.setId(ID);
        user.setEmail(EMAIL);
        user.setName(NAME);
        user.setPassword(PASSAWORD);

        return user;
    }

    public String getJsonPayload(Long id, String email, String name, String password) throws JsonProcessingException {

        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setEmail(email);
        userDTO.setName(name);
        userDTO.setPassword(password);

        // Conversão object para retornar String
        ObjectMapper objMapper = new ObjectMapper();
       
        return objMapper.writeValueAsString(userDTO);


    }

}