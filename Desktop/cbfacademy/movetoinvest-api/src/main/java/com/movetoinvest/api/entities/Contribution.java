package com.movetoinvest.api.entities;

import jakarta.persistence.*;

@Entity
public class Contribution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;
    private String status;

    @ManyToOne
    private ClientSession session;

    @ManyToOne
    private ContributionRule ruleApplied;

    public Contribution() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public double getAmount() { return amount; }
    public void setAmount(double amount) { this.amount = amount; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public ClientSession getSession() { return session; }
    public void setSession(ClientSession session) { this.session = session; }

    public ContributionRule getRuleApplied() { return ruleApplied; }
    public void setRuleApplied(ContributionRule ruleApplied) { this.ruleApplied = ruleApplied; }
}
