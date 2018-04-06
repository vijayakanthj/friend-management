# Friend-Management
API server that does simple "Friend Management"

#Swagger UI enable for testing 

`http://localhost:8080/swagger-ui.html`


## Instruction to run via docker
`docker run -p 8080:8080 vijayakanthj/friend-management`

## Instruction to build and run the project
1. `mvn clean install`
2. `java -jar target/friend-management-1.0.jar`

## API Endpoints
- `POST: /person/register`
Register an email address.
Request: `{"email":"andy@example.com"}`
Response: `{"success":true}`

- `POST: /friend/connect`
Create a friend connection between two email addresses.
Request: `{"friends":["andy@example.com","john@example.com"]}`
Response: `{"success":true}`

- `POST: /friend/list`
Retrieve the friends list for an email address.
Request: `{"email":"andy@example.com"}`
Response: `{"success":true, "friends":["john@example.com"], "count":1}`

- `POST: /friend/common`
Retrieve the common friends list between two email addresses.
Request: `{"friends":["andy@example.com","john@example.com"]}`
Response: `{"success":true, "friends":["common@example.com"], "count":1}`

- `POST: /friend/subscribe`
Subscribe to updates from an email address.
Request: `{"requestor":"andy@example.com", target:"john@example.com"}`
Response: `{"success":true}`

- `POST: /friend/block`
Block updates from an email address.
Request: `{"requestor":"andy@example.com", target:"john@example.com"}`
Response: `{"success":true}`

- `POST: /updates`
Retrieve all email addresses that can receive updates from an email address.
Request: `{"sender":"john@example.com", text:"Hello World! kate@example.com"}`
Response: `{"success":true, "recipients":["lisa@example.com","kate@example.com"]}`
