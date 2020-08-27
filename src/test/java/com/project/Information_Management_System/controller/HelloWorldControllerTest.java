package com.project.Information_Management_System.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * @author leechg31@gmail.com
 * @since 2020-08-27
 */

@SpringBootTest
class HelloWorldControllerTest {

    @Autowired  //helloWorldController에서 bean을 주입하겠다는 의미
    private HelloWorldController helloWorldController;
    private MockMvc mockMvc;

    /*@Test  //JUnit5 부터 api로 이전됌
    void helloWorld() {
        System.out.println(helloWorldController.helloWorld());

        assertThat(helloWorldController.helloWorld()).isEqualTo("HelloWorld");
    }*/

    @Test
    void mockMvcTest()
    {
        mockMvc = MockMvcBuilders.standaloneSetup(helloWorldController).build();

        try {
            mockMvc.perform(
                    MockMvcRequestBuilders.post("/api/helloWorld")
            ).andDo(MockMvcResultHandlers.print())
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andExpect(MockMvcResultMatchers.content().string("HelloWorld"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}