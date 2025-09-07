package com.movetoinvest.api.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ContributionRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)  // store as "PERCENTAGE" or "FLAT"
    private RuleType ruleType;

    // For percentage-based rules
    private Double percentageValue;

    // For flat fee rules
    private Double flatAmount;

    // Optional cap 
    private Double capAmount;

    @ManyToOne
    @JoinColumn(name = "portfolio_id")
    private Portfolio portfolio;

    public enum RuleType {
        PERCENTAGE,
        FLAT
    }
}

