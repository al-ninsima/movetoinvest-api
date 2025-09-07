package com.movetoinvest.api.services;

import com.movetoinvest.api.entities.ClientSession;
import com.movetoinvest.api.repository.ClientSessionRepository;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientSessionService {

    private final ClientSessionRepository clientSessionRepository;

    public ClientSessionService(ClientSessionRepository clientSessionRepository) {
        this.clientSessionRepository = clientSessionRepository;
    }

    // Save a new session
    public ClientSession saveSession(ClientSession session) {
        return clientSessionRepository.save(session);
    }

    // Get all sessions
    public List<ClientSession> getAllSessions() {
        return clientSessionRepository.findAll();
    }
}