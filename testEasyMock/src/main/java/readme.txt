till now we have tested code that seemed self explaining and self sufficient, meaning our code didn't depend on other
parts of the code. 
this approach does not stand in real life applications. 
applications communicate with other applications in a network.
modules communicate with other modules within the same application.
classes communicate with other classes within the same package or across different packages/modules.
methods call other methods within the same class or across different classes/packages/modules.
this will lead to complex contexts of working code leading to very complex contexts of test scenarios.

Take for example beans defined in containers.
Here a work flow is implemented across different business bean classes/methods/layers, beans
which are injected one into another and controlled by the container at different steps in the work flow.
To test such a work flow entire real life contexts would be needed. Or not?

mock = make a replica or imitation of something
sau mai pe romaneste o 'facatura'

sometimes in order to build a complex test scenario you'll need to mock some parts of it.
why mocking? well then let's just assume mocking parts of model is easier that building the real parts.

NOTE : 
-our tests will test classes with external dependencies.
-we will mock those dependencies according to our needs
-we will test that system works but also that a certain work flow is proper implemented
-we will mock only interfaces

NOTE : there are many mocking frameworks like mockito, power mock etc
NOTE : remember Proxy ???
NOTE : there are mocking frameworks capable of mocking concrete classes but this is out of scope