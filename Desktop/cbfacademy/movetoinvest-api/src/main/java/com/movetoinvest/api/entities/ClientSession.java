package com.movetoinvest.api.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity@Inheritance(strategy = InheritanceType.JOINED)

public abstract class ClientSession {
@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long instructorId;
    private LocalDateTime dateTime;
    private int durationMinutes;
    private double fee;

    // Constructors
    public ClientSession() {}

    public ClientSession(Long instructorId, LocalDateTime dateTime, int durationMinutes, double fee) {
        this.instructorId = instructorId;
        this.dateTime = dateTime;
        this.durationMinutes = durationMinutes;
        this.fee = fee;
    }

    // Abstract method
    public abstract double calculateContribution();

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getInstructorId() { return instructorId; }
    public void setInstructorId(Long instructorId) { this.instructorId = instructorId; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }
}
