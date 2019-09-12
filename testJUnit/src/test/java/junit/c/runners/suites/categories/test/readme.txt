runners/suites/categories

runners will tell JUnit how to run your test classes
runners can be customized by running tools

-typically you organize/link tests into classes
-sometimes you need to specify that some tests should be run together => link them in a test suite
-sometimes test suites overlaps test classes => categories as annotations are easy and intuitive to use

NOTE
currently eclipse runner is smart enough : 
try running all tests from this package => each test will be executed once 
even if was targeted in multiple holders