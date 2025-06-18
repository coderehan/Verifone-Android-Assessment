# Verifone-Project-Assessment

---

## Request-Response Flow

1. **User opens the app**
2. `MainActivity` triggers a request to `DashboardViewModel`
3. `DashboardViewModel` invokes `DashboardUseCase`
4. `DashboardUseCase` sequentially calls:
   - `ProfileService.getProfile()`
   - `TransactionService.getTransactions()`
   - `ConfigService.getConfig()`
5. If all succeed, a combined `DashboardData` object is returned
6. `DashboardViewModel` updates the UI state
7. UI observes state and renders data

If any service call fails, the coroutine cancels remaining operations and returns an exception.

---

## Unit Tests Covered

| Test Name                                      | Description                                              |
|-----------------------------------------------|----------------------------------------------------------|
| `test success flow returns DashboardData`     | Ensures all services return success and data combines    |
| `test failure in transaction call throws`     | Simulates failure in transaction fetch, expects exception|

---

## Sequence Diagram

A clear UML sequence diagram is prepared showing the flow between:
- **User → MainActivity → ViewModel → UseCase → Services**

This diagram helps visualize the sequential behavior and cancellation logic clearly.

---

## Key Highlights

- Strictly adheres to **structured concurrency**
- Demonstrates proper **MVVM clean architecture**
- Good separation of business logic and view logic
- Comprehensive **unit testing with fake services**

---

## License

This project is built as part of an assessment and is for educational and demonstration purposes only.
