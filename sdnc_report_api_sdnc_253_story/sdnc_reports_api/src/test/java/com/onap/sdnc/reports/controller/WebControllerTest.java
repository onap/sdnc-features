package com.onap.sdnc.reports.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.onap.sdnc.reports.Application;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes=Application.class)
@WebMvcTest(WebController.class)
public class WebControllerTest {
	
	@Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnDefaultView() throws Exception {
        this.mockMvc.perform(get("/")).andDo(print())
        .andExpect(status().isOk())
        .andExpect(view().name("index"));
    }

}
