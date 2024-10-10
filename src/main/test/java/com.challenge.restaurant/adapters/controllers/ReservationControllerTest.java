package com.challenge.restaurant.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ReservationController.class)
public class ReservationControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetReservation() throws Exception {
        mockMvc.perform(get("/reservations/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.customerName").value("Alice"));
    }

    @Test
    public void testCreateReservation() throws Exception {
        String reservationJson = "{\"customerName\":\"Bob\",\"reservationDate\":\"2024-10-15\",\"reservationTime\":\"18:00\",\"numberOfGuests\":2}";

        mockMvc.perform(post("/reservations")
                        .contentType("application/json")
                        .content(reservationJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.customerName").value("Bob"));
    }
}
