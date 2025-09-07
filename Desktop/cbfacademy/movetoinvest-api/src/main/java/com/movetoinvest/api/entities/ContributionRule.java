package com.movetoinvest.api.entities;

import jakarta.persistence.*;

@Entity
public class ContributionRule {

    public static final String PERCENTAGE = "PERCENTAGE";
    public static final String FLAT = "FLAT";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleType; // "PERCENTAGE" or "FLAT"
    private double percentageValue;
    private double capAmount;
    private double flatAmount;

    public ContributionRule() {}

    // Getters and setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getRuleType() { return ruleType; }
    public void setRuleType(String ruleType) { this.ruleType = ruleType; }

    public double getPercentageValue() { return percentageValue; }
    public void setPercentageValue(double percentageValue) { this.percentageValue = percentageValue; }

    public double getCapAmount() { return capAmount; }
    public void setCapAmount(double capAmount) { this.capAmount = capAmount; }

    public double getFlatAmount() { return flatAmount; }
    public void setFlatAmount(double flatAmount) { this.flatAmount = flatAmount; }
}
