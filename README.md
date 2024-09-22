
# Food Delivery Application (In progress)

# Project Architecture (working on it)

## Important topic to review before setting up this project
## Eureka Server
- Eureka Server is a key component in microservices architecture, particularly when using Spring Cloud Netflix. It is a service registry that helps manage and coordinate microservices within a distributed system.
- Eureka Server: Acts as a service registry where all microservices register themselves.
- Eureka Client: Each microservice instance registers with the Eureka server and can also discover other services.

## API Gateway
- An API Gateway acts as a single entry point for all client requests to the underlying microservices. It functions as a reverse proxy that routes requests, performs authentication and authorization, handles cross-cutting concerns like logging and rate limiting, and sometimes transforms responses.
- @EnableZuulProxy: is used to enable the Zuul API Gateway in a microservices architecture. Zuul is a routing gateway that forwards requests to appropriate backend services based on the request path. It acts as an intermediary between clients and the microservices, offering features like routing, load balancing, security, and filtering.
```java
<dependency>
			<groupId>org.springframework.cloud</groupId>
			<artifactId>spring-cloud-starter-netflix-zuul</artifactId>
</dependency>
```

## Kafka (Next)
- Kafka is typically used for asynchronous communication between services. Instead of making direct HTTP calls, services can publish messages to Kafka topics, and other services can subscribe to these topics to consume the messages.

## Exception Handler
An Exception Handler is a mechanism used to handle exceptions that occur in a Spring application in a centralized and consistent way. It helps to manage errors and exceptions gracefully and provides customized error responses to the client

## Mapper
- @Mapper is an annotation provided by the MapStruct library, which is a code generator that greatly simplifies the implementation of mappings between Java objects, especially when converting between Data Transfer Objects (DTOs) and entities in your application.
- This RestaurantMapper interface defines the mapping methods between Restaurant and RestaurantDTO. **MapStruct** will automatically generate the implementation at compile time if you configure it correctly.
- MapStruct is a Java-based annotation processor that generates code at compile time for mapping between Java beans, such as converting an entity to a DTO and vice versa. It eliminates the need for manual mapping code, which can be verbose and error-prone, by generating the necessary code automatically.

## Strategy Pattern
![image](https://github.com/user-attachments/assets/4ae44f5e-c78a-4600-9da9-463a975c1ef3)

- Strategy pattern: defines a family of behaviors, puts each of them into a separate class and makes their objects interchangeable.
- Key Components of the Strategy Pattern:
	- Strategy Interface: This defines a common interface for all supported algorithms.
	- Concrete Strategies: These are the classes that implement the Strategy interface, providing specific implementations of the algorithm.
	- Context: This class uses a Strategy instance to execute the algorithm. It can change the strategy dynamically if needed.

<img width="794" alt="image" src="https://github.com/user-attachments/assets/ff3fd7a2-1d83-4bf9-bc0e-bdd1df8b101e">

https://refactoring.guru/design-patterns/strategy

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
## Security using JWT authentication with API gateway and Eureka Server
![image](https://github.com/user-attachments/assets/dc9784ec-5c88-4004-9395-56cea897f8ba)

- JWT.io. (2024). Introduction to JSON Web Tokens. JWT.io. Retrieved September 5, 2024, from https://jwt.io/introduction
- Xoriant. (2023, March 1). Microservices security using JWT authentication gateway. Xoriant. Retrieved September 5, 2024, from https://www.xoriant.com/blog/microservices-security-using-jwt-authentication-gateway

## Service Communication with Feign Client
- GeeksforGeeks. (Sep, 2024). Spring boot microservices communication using feignclient with example. GeeksforGeeks. Retrieved from https://www.geeksforgeeks.org/spring-boot-microservices-communication-using-feignclient-with-example/

## Solid Principle

S - Single Responsibility Principle (SRP)
O - Open/Closed Principle (OCP)
L - Liskov Substitution Principle (LSP)
I - Interface Segregation Principle (ISP)
D - Dependency Inversion Principle (DIP)

## Project Flow
1. Client sends a request to http://api-gateway:8080/api/v1/food-delivery-app/restaurants.
2. API Gateway checks its routing rules and uses Eureka Server to find available instances of the restaurant-service.
3. API Gateway validates the JWT token included in the request.
4. Load Balancer (if configured) distributes the request to one of the instances of restaurant-service.
5. Restaurant Service processes the request and returns the response to the API Gateway.
6. API Gateway forwards the response back to the client.


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

Project Management:
- Trello: https://trello.com/b/0fDFzA7L/pos

Methodology:
- Agile
- Scrum





