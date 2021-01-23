package com.doubles.devlog.tutorial;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.inject.Inject;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring-config/**/*.xml"})
public class ControllerTest {

    private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

    @Inject
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;

    @Before
    public void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.webApplicationContext).build();
        logger.info("setup...");
    }

    @Test
    public void testVoidMapping() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/voidm"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testStringMapping() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/stringm?msg=world"))
                .andDo(print())
                .andExpect(status().isOk());
    }

    @Test
    public void testModelMapping() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/modelm"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(model().attributeExists("productVO"));
    }

    @Test
    public void testRedirectMapping() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/redirectm"))
                .andDo(print())
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("/redirectr?msg=this+is+the+message+with+redirected"));
    }

    @Test
    public void testJsonMapping() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/jsonm"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json;charset=utf-8"));
    }

}
