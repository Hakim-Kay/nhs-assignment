# Random IT Scenario Generator API

In any large IT organisation, effective training, incident response practice, and technical interviewing are critical for success. A common challenge is creating realistic and varied scenarios on-demand for these activities. This project is a simple but powerful API designed to solve that problem.

### Use Case

Imagine a team lead wants to run an incident response drill for their team. Instead of spending time manually creating a problem, they can use this API. By sending a request specifying a technology like **"Cloud Computing"** and a role like **"Software Engineer"**, they can instantly receive a randomised, relevant scenario to work through with their team.

This tool provides a practical, API-driven approach to generating dynamic content for technical education and readiness, demonstrating how a simple service can support important organisational functions.

---

## Tech Stack

* **Java 17**
* **Spring Boot 3**
* **Maven** (for dependency management)
* **JUnit 5 & Mockito** (for testing)
* **Jackson** (for JSON processing)

---

## Prerequisites

To build and run this project locally, you will need:
* Java Development Kit (JDK) 17 or higher
* Apache Maven

---

## How to Run

1.  **Clone the repository:**
    ```bash
    git clone https://github.com/Hakim-Kay/nhs-assignment.git
    ```

2.  **Navigate to the project directory:**
    ```bash
    cd assignment
    ```

3.  **Build the application package (.jar file):**
    ```bash
    ./mvnw clean install
    ```

4.  **Start the server:**
    ```bash
    java -jar target/assignment-0.0.1-SNAPSHOT.jar
    ```
    The API server is now running and listening on `http://localhost:8080`.

---

## How to Use the API

You can interact with the API by sending a `POST` request to the `/api/scenario` endpoint.

Here is an example using `curl`:

```bash
curl --location 'http://localhost:8080/api/scenario' \
--header 'Content-Type: application/json' \
--data '{
    "technology": "Cybersecurity",
    "role": "Security Analyst",
    "environment": "Enterprise Network"
}'
