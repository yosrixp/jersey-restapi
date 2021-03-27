# jersey-restapi

In this example is just to demonstrate how to build REST API using Jesey JAX-RS. The example doesn't include any real business logic. 

For exception handling you could use @Provider and implement interface ExceptionMapper<Exception> 
to handle exceptions and return proper response specially incase of 500 Internal Server Error or 400 Bad Request.


####  Run the follwoing comamndline to compile the source code or you could import the project into your IDE and compile.
```
mvn clean install
```

####  Start Jetty app server using the maven plugin.
```
 mvn clean install -Djetty.http.port=8080 org.eclipse.jetty:jetty-maven-plugin:9.4.38.v20210224:run-war
```

#### Open the following url in your browser or run curl 

####### API endpoint to get list of employees.
```
http://localhost:8080/edu/v1/employees



  {
    "employeeId": 1,
    "employeeName": "Ahmad",
    "title": "Senior Software Engineer"
  },
  {
    "employeeId": 2,
    "employeeName": "Ali",
    "title": "Staff Engineer"
  },
  {
    "employeeId": 3,
    "employeeName": "Tamer",
    "title": "Junior Software Engineer"
  }
]
```

####### API endpoint to get single employee by id
```
http://localhost:8080/edu/v1/employee/3
{
  "employeeId": 3,
  "employeeName": "Tamer",
  "title": "Junior Software Engineer"
}
```
####### API endpoint return 404 in case no employee found.
```
http://localhost:8080/edu/v1/employee/5

{
  "errorMessage": "Employee with id: 5 is not found",
  "statusCode": 404,
  "statusMessage": "Not Found"
}

```
