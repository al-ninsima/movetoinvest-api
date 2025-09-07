package com.movetoinvest.api.entities;

import jakarta.persistence.*;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String email;

    @OneToOne
    private ContributionRule defaultRule;

    public Instructor() {}

    public Instructor(String name) {
        this.name = name;
    }

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public ContributionRule getDefaultRule() { return defaultRule; }
    public void setDefaultRule(ContributionRule defaultRule) { this.defaultRule = defaultRule; }
}
