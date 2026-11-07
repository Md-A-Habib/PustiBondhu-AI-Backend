# PustiBondhu Backend – Ownership and Work Boundaries

One Maven project, one src folder. The work is separated by package folder inside src.

pustibondhu-backend/
├── pom.xml
├── OWNERSHIP.md
└── src/
    ├── main/java/com/pustibondhu/backend/
    │   ├── PustiBondhuApplication.java      (shared entry point)
    │   ├── core/                            Katon Chakma
    │   │   ├── auth, user, food, meal, nutrition, dashboard, ai, security, config
    │   │   └── common/exception/GlobalExceptionHandler.java
    │   └── health/                          Md. Ahsan Habib
    │       ├── medical, activity
    │       └── common/dto, common/exception (base response and error classes)
    ├── main/resources/
    │   ├── application.yml                  (Katon)
    │   └── db/migration/                    V1–V99 core, V100–V199 health
    └── test/java/com/pustibondhu/backend/
        ├── core/                            Katon
        └── health/                          Ahsan

## Rules to avoid conflicts
1. Edit only the folder you own (core for Katon, health for Ahsan).
2. Changes to health/common (ApiResponse, ApiError, base exceptions) need both developers to approve.
3. Code in health never imports from core. Core may import from health.
4. Health requests AI extraction through MedicalExtractionPort (in health). Katon implements it in core.ai.adapter.MedicalExtractionAdapter.
5. Use only your own Flyway version range; never edit a migration that is already merged.
6. Health refers to users by userId (Long), not by the User entity.
7. Use separate git branches (feature/core-*, feature/health-*) and merge through pull requests.
