package com.example.squadio.controllers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
@Slf4j
public class ApiControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void getUsersTest() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/users").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk()).andReturn();
    }

    @Test
    @DisplayName("Throws 500 error because of token check details matching")
    public void getUserDetailsTest() throws Exception {
        log.info("returns internal server error because of check token of some details needed");
        mockMvc.perform(MockMvcRequestBuilders.get("/users/Mohamed").accept(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().is5xxServerError()).andReturn();
    }
}
