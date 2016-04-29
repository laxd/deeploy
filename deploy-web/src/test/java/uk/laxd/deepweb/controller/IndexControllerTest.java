package uk.laxd.deepweb.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Created by lawrence on 28/04/16.
 */
public class IndexControllerTest {

    private MockMvc mockMvc;

    private IndexController indexController;

    @Before
    public void setUp() throws Exception {
        indexController = new IndexController();

        mockMvc = MockMvcBuilders.standaloneSetup(indexController)
                .build();
    }

    @Test
    public void testViewReturnedIsIndex() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(view()
                .name("index"));
    }
}