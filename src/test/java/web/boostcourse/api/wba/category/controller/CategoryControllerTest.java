package web.boostcourse.api.wba.category.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class CategoryControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();


    @Test
    @Transactional
    @WithMockUser
    public void getCategories() throws Exception{
        mockMvc.perform(get("/api/categories")
                //.header("X-AUTH-TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvb28iLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjAzMTU4MzM4LCJleHAiOjE2MDMxNjAxMzh9.Yfe0XkIJnKpffTgzPeGv9bjkan3CnSjshsDtX4r2KMM")
                .contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
