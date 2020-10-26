package web.boostcourse.api.wba.reservationInfo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import web.boostcourse.api.wba.productPrice.model.dto.request.ProductPriceRequest;
import web.boostcourse.api.wba.reservationInfo.CancelReservationParam;
import web.boostcourse.api.wba.reservationInfo.RservationInfoParam;

import java.util.Arrays;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class ReservationInfoControllerTest {

    @Autowired
    MockMvc mockMvc;
    ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void reservationInfos() throws Exception{
        //todo String -> localDate formatting
        RservationInfoParam build = RservationInfoParam
                .builder()
                .productId(1l)
                .displayInfoId(1l)
                .userId(17l)
                .reservationYearMonthDay("2020-10-26")
                .prices(Arrays.asList(ProductPriceRequest.ProductPriceParam.builder().count(2).productPriceId(3l).build()))
                .build();

        String param = objectMapper.writeValueAsString(build);
        //X-AUTH-TOKEN
        mockMvc.perform(post("/api/reservationInfos").content(param).contentType(MediaType.APPLICATION_JSON_VALUE)
                .header("X-AUTH-TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvb28iLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjAzNjk3MzYyLCJleHAiOjE2MDM2OTkxNjJ9.JFwwjWZ5dCLB3bD_t-9PqXdCbQTGVfC80333ZhjKmdk"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void getReservationInfos() throws Exception{
        mockMvc.perform(get("/api/reservationInfos")
                    .header("X-AUTH-TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvb28iLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjAzNjk3MzYyLCJleHAiOjE2MDM2OTkxNjJ9.JFwwjWZ5dCLB3bD_t-9PqXdCbQTGVfC80333ZhjKmdk"))
                .andExpect(status().isOk())
                .andDo(print());
    }

    @Test
    public void cancelReservation() throws Exception{
        CancelReservationParam build = CancelReservationParam.builder().displayInfoId(41l).build();
        String param = objectMapper.writeValueAsString(build);

        mockMvc.perform(put("/api/reservationInfos").content(param).contentType(MediaType.APPLICATION_JSON_VALUE)
                    .header("X-AUTH-TOKEN", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJvb28iLCJyb2xlcyI6WyJST0xFX1VTRVIiXSwiaWF0IjoxNjAzNjk5MTkyLCJleHAiOjE2MDM3MDA5OTJ9.oOk-RvK_FP-psfdXFg1h8aSCiSk8UIaGN5lNN-GWnzY"))
                .andExpect(status().isOk())
                .andDo(print());

        System.out.println("~!@~!@"+param);
    }

}
