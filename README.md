# HTTP API Test Cases

## Test 1: Verify HTTP Status Code
### Description
This test verifies that a GET request to the given URL returns a 200 OK status code.

### Steps
1. Send an HTTP GET request to `https://jsonplaceholder.typicode.com/users`.
2. Validate that the status code of the obtained response is `200 OK`.

## Test 2: Verify HTTP Response Header
### Description
This test verifies that the response contains a `Content-Type` header and that its value is correct.

### Steps
1. Send an HTTP GET request to `https://jsonplaceholder.typicode.com/users`.
2. Validate that the `Content-Type` header exists in the response.
3. Validate that the value of the `Content-Type` header is `application/json; charset=utf-8`.

## Test 3: Verify HTTP Response Body
### Description
This test verifies that the response body contains an array of 10 users.

### Steps
1. Send an HTTP GET request to `https://jsonplaceholder.typicode.com/users`.
2. Validate that the response body contains an array of 10 users.

## Acceptance Criteria
- Tests should be created using either **Rest Assured** or **Spring Rest Template**.
- Tests must include the specified validations.
- Implemented tests should be **readable**.
- Tests should be implemented to **run in parallel**.
- Naming and code conventions should be followed.
- **Bonus Task**: Additional tests should cover CRUD operations for the given resource.
