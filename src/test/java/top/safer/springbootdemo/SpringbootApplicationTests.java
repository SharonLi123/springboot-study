package top.safer.springbootdemo;


import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import top.safer.springbootdemo.web.HelloController;
import org.junit.Test;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;

@WebAppConfiguration
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootApplicationTests {

	private MockMvc mockMvc;

	@Autowired
	private WebApplicationContext applicationContext;

	@Before
	public void init(){
		mockMvc = MockMvcBuilders.standaloneSetup(new HelloController()).build();
	}

	@Test
	public void getHello() throws Exception {
		System.out.println(mockMvc);
		mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=小明")
				.accept(MediaType.APPLICATION_JSON_UTF8)).andDo(print());
	}

	@Test
	public void getHello2() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/hello?name=小明")
		.accept(MediaType.APPLICATION_JSON_UTF8))
				.andExpect(MockMvcResultMatchers.content().string(Matchers.containsString("hh")));
	}


	@Test
	public void contextLoads() {
	}

}
