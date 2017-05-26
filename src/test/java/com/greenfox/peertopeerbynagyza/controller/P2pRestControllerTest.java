package com.greenfox.peertopeerbynagyza.controller;

import com.greenfox.peertopeerbynagyza.PeertopeerbynagyzaApplication;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PeertopeerbynagyzaApplication.class)
@WebAppConfiguration
@EnableWebMvc
public class P2pRestControllerTest {

  private MockMvc mockMvc;

  @Autowired
  WebApplicationContext webApplicationContext;

  @Before
  public void setUp() throws Exception {
    this.mockMvc = webAppContextSetup(webApplicationContext).build();
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public void receiveMessageAllOk() throws Exception {
    mockMvc.perform(post("/api/message/receive").contentType(MediaType.APPLICATION_JSON)
            .content("{\n" +
                    "  \"message\": {\n" +
                    "    \"id\": 7655482,\n" +
                    "    \"username\": \"EggDice\",\n" +
                    "    \"text\": \"How you doin'?\",\n" +
                    "    \"timestamp\": 1322018752992\n" +
                    "  },\n" +
                    "  \"client\": {\n" +
                    "    \"id\": \"EggDice\"\n" +
                    "  }\n" +
                    "}"))
            .andExpect(status().isOk());
  }

}