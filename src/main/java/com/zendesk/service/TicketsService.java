package com.zendesk.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.zendesk.dao.TicketRepository;
import com.zendesk.dto.TicketResponse;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@AllArgsConstructor(onConstructor = @__({@Autowired}))
@Service
public class TicketsService {

    private TicketRepository ticketRepository;
    private ObjectMapper objectMapper;

    public List<TicketResponse> getAllTickets() {
        String response;
        response = ticketRepository.fetchAllTickets();
        Map<String, Object> map = new HashMap<>();
        List<TicketResponse> tickets = null;
        try {
            map = objectMapper.readValue(response, Map.class);
            String json = objectMapper.writeValueAsString(map.get("tickets"));
            tickets = objectMapper.readValue(json, new TypeReference<List<TicketResponse>>() {
            });
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return tickets;
    }
}
