package com.empresa.dam.apiacuioximetro.controller;

import com.empresa.dam.apiacuioximetro.dto.AuthenticationRequest;
import com.empresa.dam.apiacuioximetro.dto.AuthenticationResponse;
import com.empresa.dam.apiacuioximetro.repository.UsuarioRepository;
import com.empresa.dam.apiacuioximetro.service.AuthenticationService;
import com.empresa.dam.apiacuioximetro.service.JwtService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
@AutoConfigureMockMvc(addFilters = false)
@MockBeans({
        @MockBean(UsuarioRepository.class),
        @MockBean(JwtService.class)
})
class AuthControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private AuthenticationService authService;
    @Autowired
    private ObjectMapper objectMapper;
    private AuthenticationResponse authResponse;

    @BeforeEach
    void setUp() {
        authResponse = new AuthenticationResponse("eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJzdWIiOiIxMjM0NTY3ODkwIiwibmFtZSI6IkpvaG4gRG9lIiwiaWF0IjoxNTE2MjM5MDIyfQ.SflKxwRJSMeKKF2QT4fwpMeJf36POk6yJV_adQssw5c");
    }

    @Test
    void AuthenticationController_ValidatedLogin_ReturnJwt() throws Exception {
        when(authService.login(Mockito.mock(AuthenticationRequest.class))).thenReturn(authResponse);
        mockMvc.perform(post("/auth/authenticate")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(new AuthenticationRequest("Angel", "1234"))))
                .andExpect(status().isOk());
    }
}