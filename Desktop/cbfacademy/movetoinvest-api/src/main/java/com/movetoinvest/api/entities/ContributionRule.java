package com.movetoinvest.api.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class ContributionRule {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Double percentageOfFee; // can be null if flatAmount is used
    private Double flatAmount;      // can be null if percentageOfFee is used
    private Double cap;
    private Boolean active;

    public ContributionRule() {}

    public ContributionRule(Double percentageOfFee, Double flatAmount, Double cap, Boolean active) {
        this.percentageOfFee = percentageOfFee;
        this.flatAmount = flatAmount;
        this.cap = cap;
        this.active = active;
    }

    // Getters & Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Double getPercentageOfFee() { return percentageOfFee; }
    public void setPercentageOfFee(Double percentageOfFee) { this.percentageOfFee = percentageOfFee; }

    public Double getFlatAmount() { return flatAmount; }
    public void setFlatAmount(Double flatAmount) { this.flatAmount = flatAmount; }

    public Double getCap() { return cap; }
    public void setCap(Double cap) { this.cap = cap; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

}
