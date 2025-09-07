# move to invest

Teach today, invest tomorrow — your work builds your wealth.

Move to Invest is a fitness instructor focused investment automation API. It allows fitness instructors, personal trainers, and wellness professionals to log their classes or client sessions. The system then automatically calculates contributions to investment portfolios based on configurable rules.

Every session (group class or private session) generates contributions that are tracked against the instructor’s selected portfolio, making it easier to invest consistently without extra effort.

The API is built with Spring Boot, MySQL, and Spring Data JPA, and exposes a RESTful interface.

Instructor-focused workflow: Sessions → Contributions → Portfolio

Automatic contribution calculation:
- Flat-fee rule: e.g., $50 per session
- Percentage rule: e.g., 10% of session fee
- Cap enforcement: prevents contributions from exceeding a maximum

Entities and Relationships
| Entity                   | Key Fields                                           | Notes                                        |
| ------------------------ | ---------------------------------------------------- | -------------------------------------------- |
| Instructor               | id, name, email                                      | Can have multiple sessions and contributions |
| ClientSession (abstract) | id, instructorId, dateTime, durationMinutes, fee     | Base class for sessions                      |
| GroupClassSession        | –                                                    | Extends ClientSession                        |
| PrivateSession           | –                                                    | Extends ClientSession                        |
| Portfolio                | id, name, riskLevel                                  | Holds contributions for instructors          |
| ContributionRule         | id, ruleType, percentageValue, flatAmount, capAmount | Determines contribution calculation          |
| Contribution             | id, sessionId, portfolioId, amount, status           | Tied to session and rule applied             |


HOW IT WORKS

Instructor logs a session (POST /sessions)
- System assigns session to instructor and stores duration, fee, and type.

Contribution is calculated via ContributionService
- Checks the associated ContributionRule
- Applies flat or percentage logic
- Enforces cap if defined

Contribution is saved (Contribution entity)
- Linked to session and portfolio

Reports / Retrieval
- GET /contributions to list contributions
- GET /portfolios to view total contributions per portfolio



TO WORK ON

Fix database seeding and foreign key issues
Complete ContributionService
Finalise Unit and Integration Tests
Finalise API endpoints
Better exception handling
Swagger/OpenAPI documentation

API Endpoints
Instructors
- POST /instructors – Add new instructor
- GET /instructors – List all instructors
- GET /instructors/{id} – Get instructor by ID
- PATCH /instructors/{id} – Update instructor
- DELETE /instructors/{id} – Delete instructor

Sessions
- POST /sessions – Save group or private session
- GET /sessions – List all sessions (filterable by instructor, type, date)
- GET /sessions/{id} – Retrieve specific session
- PATCH /sessions/{id} – Update session
- DELETE /sessions/{id} – Delete session

Contribution Rules
- CRUD endpoints for managing rules
- Supports percentage or flat contributions, with optional caps

Contributions
- POST /contributions – Record a contribution (calculated automatically from session)
- GET /contributions – List contributions (filterable)
- GET /contributions/preview – Optional: preview contribution without saving

Portfolios
- POST /portfolios – Add portfolio
- GET /portfolios – List portfolios
- PATCH /portfolios/{id} – Update portfolio
- DELETE /portfolios/{id} – Delete portfolio

How to Set Up

Install Prerequisites:
Java 21+
Maven
MySQL

- Clone and Build
- Configure MySQL in application.properties:
- Run Application
- Seed Data (Use data.sql for initial instructors, sessions, portfolios, rules, and contributions.)

Example API Flow

- Instructor logs a session (POST /sessions).
- ContributionService calculates contribution → posts to portfolio.
- Contributions can be queried (GET /contributions) and filtered by instructor/date/status.
- Optional: Preview contributions before committing.

Future Evolution

- Integrate with Stripe or MindBody for automated session imports.
- Suggest portfolios automatically based on instructor profile.
- Add gamification: streaks, leaderboard, or contribution challenges.
- Support multi-currency portfolios.
- Advanced reporting and analytics for instructors.
