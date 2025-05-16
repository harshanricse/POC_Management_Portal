# POC_Management_Portal
building a backend REST API for a POC(Proof of Concept) Management Portal

Functional Requirements
Implement a Spring Boot REST API with the following capabilities
1. Create a New POC
   EndPoint to create a new POC entry.
   The request should accept the following fields:
     pocObjective(String)
     startDate(Date)
     endDate(Date)
     technology(String)
     projectName(String)
     status(Enum: e.g., IN_PROGRESS, COMPLETED, ON_HOLD)
     keyLearnings(String)
     spocName(String)
     spocEmail(String)
     spocContact(String)
     codeLocation(URL/String)
     reviewedBy(String, optional)
2. List All POCs
   Endpoint to retrieve all POC entries.
   support optional filtering by status, technology, or projectName.
3. Update an Existing POC
   Endpoint to update any of the fields of an existing POC using its unique ID.
4. Delete a POC
   Endpoint to delete a POC by its ID.

Technical Requirements
  1. Use SpringBoot and SpringDataJPA.
  2. use an in-memory database like H2 for simplicity.
  3. Follow RESTful best practices(use appropiate HTTP methods and status codes).
  4. Include basic validation(e.g., email format, required fields).
  5. Use DTOs and service layers to maintain clean architecture

Evaluation Criteria
  1. Code structure and readability
  2. RESTful API design and adherence to best practices
  3. Use of Spring Boot features(annotations, dependecy injection e.t.c)
  4. Data modeling and validation
  5. Error handling and response structure


















   
