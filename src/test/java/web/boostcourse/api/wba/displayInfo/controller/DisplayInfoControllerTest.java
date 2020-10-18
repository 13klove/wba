package web.boostcourse.api.wba.displayInfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class DisplayInfoControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void getDisplayInfos() throws Exception{
        MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
        param.add("categoryId", "3");
        param.add("start", "1");

        String paramValue = objectMapper.writeValueAsString(param);
        mockMvc.perform(get("/api/displayinfos").contentType(MediaType.APPLICATION_JSON_VALUE).params(param))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getDisplayInfoDetail() throws Exception{
        mockMvc.perform(get("/api/displayinfos/1").contentType(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().isOk())
                .andDo(print());
    }

}
