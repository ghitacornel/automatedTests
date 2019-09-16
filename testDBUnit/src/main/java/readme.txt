DBUnit is an "extension" of JUnit intended for database targeted tests.
DBUnit is able to verify database state before, during or after tested code is executed.
DBUnit can be used for example in testing stored procedures (via JDBC calls) that change database state,
making it useful testing part of application business implemented in these stored procedures.
Sometimes application business can be so critical that even simple inserts are required to be tested. 

Matching data extracted form the database with data provided in XML files can be problematic.
Data ordering, conversions, formats must be taken into account.
DBUnit allow us the possibility to ignore columns when matching data sets.

DBUnit tests can be executed in a 'transactional' or 'not transactional' manner.
'transactional' tests are executed within a database transaction boundary, transaction which is rolled back at the ned of the test.
'non transactional' tests use multiple transactions hence in case of failure the database state can be left corrupted.

That's why we need to take extra care when building initial setups for our tests.
Database cleanup after test execution is redundant but present here for demo purpose.
Due to complex setups and database working concepts database tests are hard to execute in concurrent manner.

How to test in a 'transactional' manner will be presented further

This kind of tests are considered integration tests. 
Integration testing is the phase in software testing in which individual software modules 
are combined and tested as a group.

TODO test over JPA
TODO test transactional