package dependencies.privates.defaults;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ServiceWithPrivateDependenciesRefactoredTest {

    @InjectMocks
    @Spy
    ServiceWithPrivateDependenciesRefactored service;

    @Test
    public void testHappyPath() {

        // 1
        // create test context

        // 1
        // 1.1
        // create input data
        int x = 11;
        int y = 22;

        // 1.2
        // create expected result
        int expectedResult = 33;

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations
        Assert.assertEquals(expectedResult, actualResult);
        Mockito.verify(service).complexBusiness(x, y);
        Mockito.verify(service).validate(x, y);
        Mockito.verifyNoMoreInteractions(service);
    }

    @Test
    public void testSpecialCaseFirstParameterLessThan10() {

        // 1
        // create test context

        // 1
        // 1.1
        // create input data
        int x = 8;
        int y = 10;

        // 1.2
        // create expected result
        int expectedResult = -10;

        // mock parts of the spied object
        Mockito.doReturn(expectedResult).when(service).calculateSpecific(x, y);

        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations
        Assert.assertEquals(expectedResult, actualResult);
        Mockito.verify(service).complexBusiness(x, y);
        Mockito.verify(service).validate(x, y);
        Mockito.verify(service).calculateSpecific(x, y);
        Mockito.verifyNoMoreInteractions(service);

    }

    @Test
    public void testSpecialCaseSecondParameterLessThan10() {

        // 1
        // create test context

        // 1
        // 1.1
        // create input data
        int x = 10;
        int y = 8;

        // 1.2
        // create expected result
        int expectedResult = -10;
        // mock parts of the spied object
        Mockito.doReturn(expectedResult).when(service).calculateSpecific(x, y);


        // 2
        // 2.1 invoke to be tested method
        // 2.2 and collect result
        int actualResult = service.complexBusiness(x, y);

        // 3
        // verify expectations
        // 3.1
        // verify I/O expectations
        Assert.assertEquals(expectedResult, actualResult);
        Mockito.verify(service).complexBusiness(x, y);
        Mockito.verify(service).validate(x, y);
        Mockito.verify(service).calculateSpecific(x, y);
        Mockito.verifyNoMoreInteractions(service);

    }

    // test "default"ed dependencies separately
    @Test
    public void calculateSpecific() {
        Assert.assertEquals(3, service.calculateSpecific(2, 4));
    }

    // test "default"ed dependencies separately
    @Test(expected = IllegalArgumentException.class)
    public void validateFirstNegative() {
        service.validate(-10, 10);
    }

    // test "default"ed dependencies separately
    @Test(expected = IllegalArgumentException.class)
    public void validateSecondNegative() {
        service.validate(10, -10);
    }

}
