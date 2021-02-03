package top.safer.springbootdemo.web;

import org.junit.Before;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.Assert.*;

@SpringBootTest
public class WebControllerTest {

    private MockMvc mockMvc;

    @Before
    public void init(){
        mockMvc= MockMvcBuilders.standaloneSetup(new WebController()).build();
    }

    @Test
    public void getUser() throws Exception {
        String responseString=mockMvc.perform(MockMvcRequestBuilders.post("/getUser")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result: "+responseString);
    }

    @Test
    public void saveUser() throws Exception {
        String responseString=mockMvc.perform(MockMvcRequestBuilders.post("/saveUser")
                .param("name","")
                .param("age","666")
                .param("pass","test")
                .accept(MediaType.APPLICATION_JSON_UTF8))
                .andReturn().getResponse().getContentAsString();
        System.out.println("result: "+responseString);
    }
}