# Supermarket Checkout Service
### Building the project:

mvn clean install

### Running the project:

java -jar target/checkout-0.0.1-SNAPSHOT.jar

### Description:

The service exposes a REST endpoint /v1/api/basket which expects a list of items (a list of strings) then calculates the total price.

### ToDo:

1. Unit test coverage

2. Mock API/add functional tests