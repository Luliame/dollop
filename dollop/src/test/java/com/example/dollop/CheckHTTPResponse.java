// package com.example.dollop;

// import org.junit.jupiter.api.Test;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
// import org.springframework.boot.test.context.SpringBootTest;
// import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
// import org.springframework.boot.test.mock.mockito.MockBean;
// import org.springframework.boot.test.web.client.TestRestTemplate;
// import org.springframework.boot.web.server.LocalServerPort;
// import org.springframework.test.context.ContextConfiguration;
// import org.springframework.test.web.servlet.MockMvc;

// import com.example.dollop.manager.ArticleManager;
// import com.example.dollop.model.dto.ArticleDto;
// import com.example.dollop.service.impl.ArticleServiceImpl;

// import static org.assertj.core.api.Assertions.assertThat;
// import static org.mockito.Mockito.when;


// import static org.hamcrest.Matchers.containsString;
// import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
// import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
// import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



// @WebMvcTest(ArticleManager.class)
// @ContextConfiguration(classes=DollopApplication.class)
// @SpringBootTest
// public class CheckHTTPResponse {

// 	@Autowired
// 	private MockMvc mockMvc;

// 	@MockBean
// 	private ArticleServiceImpl service;

// 	@Test
// 	public void getArticleByIdTest() throws Exception {
// 		var i = new ArticleDto("michel", "non", 7);
// 		when(service.findByName("michel")).thenReturn(i);
// 	}
// 	//.string(containsString("Hello, Mock"))
// }