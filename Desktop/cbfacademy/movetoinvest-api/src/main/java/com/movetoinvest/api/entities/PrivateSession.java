package com.movetoinvest.api.entities;

import jakarta.persistence.Entity;

@Entity
public class PrivateSession extends ClientSession {
   public PrivateSession() {}

    public PrivateSession(Long instructorId, java.time.LocalDateTime dateTime, int durationMinutes, double fee) {
        super(instructorId, dateTime, durationMinutes, fee);
    }

    @Override
    public double calculateContribution() {
        return getFee(); // Example: full fee for private session
    }
}
