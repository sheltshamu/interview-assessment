# Interview-assessment

## Requirements
For building and running the application you need:
- JDK 17
- Maven

## Building the project
`mvn clean install`

## Running the project
`mvn spring-boot:run`

## h2-console`
`URL : localhost:8100/h2-console` - 
`Username : sa`
`Password : password`

## Execution
Open a terminal at the root of the project and run the following command:
```
java -jar target/drones-0.0.1-SNAPSHOT.jar
```

# Documentaion

1. Drone Registration

    ```bash
    curl --location --request POST 'http://localhost:8081/api/v1/drone/register' \
    --header 'Content-Type: application/json' \
    --data-raw '{
          "serialNumber":"Y2419Q",
          "batteryLevel":100,
          "model":"LIGHT_WEIGHT",
          "weightLimit":500,
          "state":"IDLE"
    }'
    ```

2. Load Drone with Medication
    
    ```bash
    curl --location --request POST 'http://localhost:8081/api/v1/drone/load' \
    --header 'Content-Type: application/json' \
    --data-raw '{
          "name": "ABC",
          "weight": 150,
          "code": "X1Y2Z3",
          "droneId": 1,
         "image": {
              "name": "example.jpg",
              "type": "image/jpeg",
              "content": "base64-encoded-content"
          }
    }'
    ```

3. Find Available Drones
    ```bash
    curl --location --request GET 'http://localhost:8081/api/v1/find-all-available'
    ```

4. Get Drone or Get Drone battery
    ```bash
    curl --location --request GET 'http://localhost:8081/api/v1/1/battery'
    ```
5. Get Loaded Medication by droneId
    ```bash
    curl --location --request GET 'http://localhost:8081/api/v1/loaded-items/1'
    ```

6. Postman Collection
    - Begin by launching the Postman application and proceed to import the collection using the provided link: https://api.postman.com/collections/28272422-334ea267-3e52-476b-b802-d1df4b2270e5?access_key=PMAT-01H5A8JTB7ABXNE87F62DX6JAM. Subsequently, utilize the imported collection to execute thorough testing of the RESTful APIs.
