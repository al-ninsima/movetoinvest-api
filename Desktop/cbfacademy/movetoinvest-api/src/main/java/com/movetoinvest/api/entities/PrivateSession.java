package com.movetoinvest.api.entities;

import jakarta.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class PrivateSession extends ClientSession {

    public PrivateSession() {}

    public PrivateSession(Instructor instructor, LocalDateTime dateTime, int durationMinutes, double fee) {
        super(instructor, dateTime, durationMinutes, fee);
    }

    @Override
    public double calculateContribution() {
        return getFee();
    }
}
