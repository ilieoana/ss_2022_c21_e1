package com.example.ss_2022_c21_e1;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@SpringBootTest
@AutoConfigureMockMvc
class Ss2022C21E1ApplicationTests {

    @Autowired
    private MockMvc mvc;

    @Test
    void test1() throws Exception {
        mvc.perform(get("/demo")
                        .with(httpBasic("bill","12345")))
                .andExpect(status().isOk());
    }

    @Test
    void test2() throws Exception {
        mvc.perform(post("/hello")
                        .with(httpBasic("bill","12345"))
                        .with(csrf()))
                .andExpect(status().isOk());
    }

}
