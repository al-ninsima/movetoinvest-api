-- Instructors
INSERT INTO instructor (id, name, email) VALUES (1, 'Alice N', 'alice@example.com');
INSERT INTO instructor (id, name, email) VALUES (2, 'Casper G', 'casper@example.com');

-- Portfolios
INSERT INTO portfolio (id, name, risk_level) VALUES (1, 'Growth Portfolio', 'High');
INSERT INTO portfolio (id, name, risk_level) VALUES (2, 'Income Portfolio', 'Low');

-- Contribution Rules
INSERT INTO contribution_rule (id, rule_type, percentage_value, flat_amount, cap_amount) 
VALUES (1, 'PERCENTAGE', 10.0, 0, 500);

INSERT INTO contribution_rule (id, rule_type, percentage_value, flat_amount, cap_amount) 
VALUES (2, 'FLAT', 0, 50, 100);

-- Client Sessions
-- Group session
INSERT INTO client_session (id, instructor_id, date_time, duration_minutes, fee)
VALUES (1, 1, '2025-09-05 10:00:00', 60, 100);

-- Private session
INSERT INTO client_session (id, instructor_id, date_time, duration_minutes, fee)
VALUES (2, 2, '2025-09-05 11:00:00', 45, 150);

-- Group Class Session (child)
INSERT INTO group_class_session (id, max_participants)
VALUES (1, 10);

-- Private Session (child)
INSERT INTO private_session (id)
VALUES (2);

-- Contributions
INSERT INTO contribution (id, session_id, portfolio_id, amount, status, rule_applied_id)
VALUES (1, 1, 1, 50, 'PENDING', 1);

INSERT INTO contribution (id, session_id, portfolio_id, amount, status, rule_applied_id)
VALUES (2, 2, 2, 30, 'PENDING', 2);
