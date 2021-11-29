package com.zendesk.controller;

import com.zendesk.service.TicketsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(value = "*")
@AllArgsConstructor(onConstructor = @__({@Autowired}))
public class TicketsController {
    private TicketsService ticketsService;

    @GetMapping("/tickets/list")
    public ResponseEntity<List> getTickets() {
        return ResponseEntity.ok(ticketsService.getAllTickets());
    }
}
