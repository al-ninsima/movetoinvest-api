package com.movetoinvest.api.entities;

import jakarta.persistence.Entity;

@Entity
public class GroupClassSession extends ClientSession {
    private int numberOfParticipants;

    public GroupClassSession() {}

    public GroupClassSession(Long instructorId, java.time.LocalDateTime dateTime, int durationMinutes, double fee, int numberOfParticipants) {
        super(instructorId, dateTime, durationMinutes, fee);
        this.numberOfParticipants = numberOfParticipants;
    }

    @Override
    public double calculateContribution() {
        return getFee() * 0.5; // Example: 50% of fee goes to contribution
    }

    public int getNumberOfParticipants() { return numberOfParticipants; }
    public void setNumberOfParticipants(int numberOfParticipants) { this.numberOfParticipants = numberOfParticipants; }

}
