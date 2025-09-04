-- Instructors
INSERT INTO instructor (id, name) VALUES (1, 'Alice Smith');
INSERT INTO instructor (id, name) VALUES (2, 'Bob Johnson');

-- Portfolios
INSERT INTO portfolio (id, name, risk_level) VALUES (1, 'Growth Portfolio', 'High');
INSERT INTO portfolio (id, name, risk_level) VALUES (2, 'Income Portfolio', 'Low');

-- Contribution Rules
INSERT INTO contribution_rule (id, percentage_of_fee, flat_amount, cap, active) 
VALUES (1, 10.0, NULL, 500, TRUE);
INSERT INTO contribution_rule (id, percentage_of_fee, flat_amount, cap, active) 
VALUES (2, NULL, 50, 100, TRUE);

-- Group Class Sessions
INSERT INTO group_class_session (id, instructor_id, date_time, duration_minutes, fee, number_of_participants)
VALUES (1, 1, '2025-09-05 10:00:00', 60, 100, 10);

-- Private Sessions
INSERT INTO private_session (id, instructor_id, date_time, duration_minutes, fee)
VALUES (2, 2, '2025-09-05 11:00:00', 45, 150);

-- Contributions
INSERT INTO contribution (id, session_id, portfolio_id, amount, status)
VALUES (1, 1, 1, 50, 'PENDING');
INSERT INTO contribution (id, session_id, portfolio_id, amount, status)
VALUES (2, 2, 2, 30, 'PENDING');
