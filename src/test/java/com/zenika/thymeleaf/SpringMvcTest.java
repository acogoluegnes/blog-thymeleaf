package com.zenika.thymeleaf;

import com.zenika.ContactConfiguration;
import com.zenika.business.ContactService;
import com.zenika.business.StubContactService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import static org.hamcrest.CoreMatchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.*;

/**
 *
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@WebAppConfiguration
public class SpringMvcTest {

    @Autowired
    WebApplicationContext ctx;

    MockMvc mvc;

    @Before public void setUp() throws Exception {
        mvc = webAppContextSetup(ctx).build();
    }

    @Test
    public void contact() throws Exception {
        mvc.perform(get("/contacts"))
//            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().string(containsString("John")))
            .andExpect(content().string(containsString("Jane")));

    }

    @Configuration
    @Import(ContactConfiguration.class)
    public static class TestConfiguration {

        @Bean
        public ContactService contactService() {
            return new StubContactService();
        }

    }

}
