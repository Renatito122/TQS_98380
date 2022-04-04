# LAB3 exercice 1 questions

## Identify a couple of examples on the use of AssertJ expressive methods chaining



EmployeeRepositoryTest
    - assertThat(fromDb.getEmail()).isEqualTo( emp.getEmail());
    - assertThat(allEmployees).hasSize(3).extracting(Employee::getName).containsOnly(alex.getName(), ron.getName(), bob.getName());

EmployeeRestControllerIT
    - assertThat(found).extracting(Employee::getName).containsOnly("bob");

EmployeeRestControllerTemplateIT
    - assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    assertThat(found).extracting(Employee::getName).containsOnly("bob");

EmployeeService_UnitTest
    - assertThat(allEmployees).hasSize(3).extracting(Employee::getName).contains(alex.getName(), john.getName(), bob.getName());


## Identify an example in which you mock the behavior of the repository (and avoid involving a database)

In EmployeeService_UnitTest class the EmployeeRepository is mocked using the annotation @Mock and then modeling the expected behaviour in the setUp() function.

## What is the difference between standard @Mock and @MockBean?

@Mock is a shorthand for the Mockito.mock() method. It's important to note that we should only use it in a test class. We need to enable Mockito annotations to use this annotation.
We can do this either by using the MockitoJUnitRunner to run the test, or by calling the MockitoAnnotations.initMocks() method explicitly.
This annotation makes it easier to find the problem mock in case of a failure, as the name of the field appears in the failure message

On the other hand, we can use the @MockBean to add mock objects to the Spring application context. The mock will replace any existing bean of the same type in the application context.
If no bean of the same type is defined, a new one will be added. This annotation is useful in integration tests where a particular bean, like an external service, needs to be mocked.
To use this annotation, we have to use SpringRunner to run the test.
When we use the annotation on a field, the mock will be injected into the field, as well as being registered in the application context.

## What is the role of the file “application-integrationtest.properties”? In which conditions will it be used?

The application-integrationtest.properties file contains the details to configure the persistence storage.

The anotation @TestPropertySource commented in the D_EmployeeRestControllerIT file class allows to configure the locations of properties files specific to the tests. In this case the configuration file to be used should be the application-integrationtest.properties file

## The sample project demonstrates three test strategies to assess an API (C, D and E) developed with SpringBoot.Which are the main/key differences?

