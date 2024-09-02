
# Food Delivery Application (In progress)

## Eureka Server
- Eureka Server is a key component in microservices architecture, particularly when using Spring Cloud Netflix. It is a service registry that helps manage and coordinate microservices within a distributed system.

## API Gateway
An API Gateway acts as a single entry point for all client requests to the underlying microservices. It functions as a reverse proxy that routes requests, performs authentication and authorization, handles cross-cutting concerns like logging and rate limiting, and sometimes transforms responses.

## Naming Rule of API endpoint
- Use Nouns for Resources: Use nouns to represent resources (e.g., restaurants, orders, users).
- Plural Form: Use the plural form for resource names when referring to collections (e.g., /restaurants, /orders).
```java
GET /restaurants   // Retrieves a list of restaurants
POST /restaurants  // Creates a new restaurant
GET /restaurants/{restaurantId}  // Retrieves a specific restaurant
```
- Use Hyphens (-) to Separate Words: Hyphens are preferred over underscores (_) for readability in URLs.

```java
GET /restaurant-reviews // Good
GET /restaurant_reviews // Avoid
```
- Use lower Case: Always use lowercase letters in URLs. Avoid camelCase or PascalCase.
```java
GET /restaurants/{restaurantId}/reviews  // Good
GET /Restaurants/{RestaurantId}/Reviews  // Avoid
```

- Good Example
```java
GET /restaurants             // Retrieves a list of restaurants
POST /restaurants            // Creates a new restaurant
GET /restaurants/{restaurantId}  // Retrieves a specific restaurant
PUT /restaurants/{restaurantId}  // Updates a specific restaurant
DELETE /restaurants/{restaurantId} // Deletes a specific restaurant
```
- Avoid verb in the URLs: The HTTP method should describe the action, not the endpoint name itself.
```java
POST /restaurants   // Correct (creates a restaurant)
GET /deleteRestaurant/{restaurantId}  // Avoid (delete should be an HTTP DELETE request)
```
## Path Variable Binding
Is the process in web development where a value from a specific segment of a URL path (known as a path variable) is extracted and passed as an argument to a controller method in a web application. This binding allows dynamic interaction with resources based on the values specified in the URL.
```java
@GetMapping("/restaurants/{restaurantId}")
public ResponseEntity<RestaurantDTO> getRestaurantById(@PathVariable("restaurantId") int id) {
    // 'restaurantId' in the URI is bound to the 'id' parameter in the method
    return restaurantService.getRestaurantById(id);
}
```

## Technology used:
Frontend:
- Angular, Typescript
- Tool: Vscode
- Testing: Jasmine , Kamar

Backend:
- Rest/ Restful
- Spring boot
- Microservices
- Github
- Junit, TDD, Mockito
- Tool: IntelliJ

Database:
- SQL
- MySQL db

Deployment:
- Sonar
- Docker
- Kubernetes
- AWS EKS
- AWS ALB
- AWS EC2
- AWS RDS (SQL)
- Mongo Atlas (No-SQL)
- Jenkins
- ArgoCD
- CI/CD

Methodology:
- Agile
- Scrum





