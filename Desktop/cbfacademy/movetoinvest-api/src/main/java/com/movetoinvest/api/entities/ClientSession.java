package com.movetoinvest.api.entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ClientSession {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateTime;
    private int durationMinutes;
    private double fee;

    @ManyToOne
    private Instructor instructor;

    public ClientSession() {}

    public ClientSession(Instructor instructor, LocalDateTime dateTime, int durationMinutes, double fee) {
        this.instructor = instructor;
        this.dateTime = dateTime;
        this.durationMinutes = durationMinutes;
        this.fee = fee;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public LocalDateTime getDateTime() { return dateTime; }
    public void setDateTime(LocalDateTime dateTime) { this.dateTime = dateTime; }

    public int getDurationMinutes() { return durationMinutes; }
    public void setDurationMinutes(int durationMinutes) { this.durationMinutes = durationMinutes; }

    public double getFee() { return fee; }
    public void setFee(double fee) { this.fee = fee; }

    public Instructor getInstructor() { return instructor; }
    public void setInstructor(Instructor instructor) { this.instructor = instructor; }

    public abstract double calculateContribution();
}
