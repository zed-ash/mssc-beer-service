package zed.springframework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import zed.springframework.msscbeerservice.web.model.BeerDto;

import java.util.UUID;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    @Autowired
    MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void getBeerById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/beer/" + UUID.randomUUID().toString()).accept(MediaType.APPLICATION_JSON))
                        .andExpect(MockMvcResultMatchers.status().isOk());
    }

    @Test
    void saveBeer() throws Exception {
        BeerDto beerDto= BeerDto.builder().build();
        String beerDtoJson= objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(MockMvcRequestBuilders
                        .post("/api/v1/beer")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                        .andExpect(MockMvcResultMatchers.status().isCreated());
    }

    @Test
    void updateBeerByID() throws Exception {
        BeerDto beerDto= BeerDto.builder().build();
        String beerDtoJson= objectMapper.writeValueAsString(beerDto);

        mockMvc.perform(MockMvcRequestBuilders
                        .put("/api/v1/beer/"+ UUID.randomUUID().toString())
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(beerDtoJson))
                        .andExpect(MockMvcResultMatchers.status().isNoContent());
    }
}