package com.movetoinvest.api.controllers;

import com.movetoinvest.api.entities.ClientSession;
import com.movetoinvest.api.services.ClientSessionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class ClientSessionController {
    private final ClientSessionService clientSessionService;

    public ClientSessionController(ClientSessionService clientSessionService) {
        this.clientSessionService = clientSessionService;
    }

    @PostMapping
    public ClientSession createSession(@RequestBody ClientSession session) {
        return clientSessionService.saveSession(session);
    }

    @GetMapping
    public List<ClientSession> getAllSessions() {
        return clientSessionService.getAllSessions();
    }

}
