package random;

import model.Person;
import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.junit.Test;

public class RandomTest {

    @Test
    public void testRandomGeneratedModel() {

        EasyRandomParameters parameters = new EasyRandomParameters();
        parameters.stringLengthRange(3, 3);
        parameters.collectionSizeRange(5, 5);
        parameters.randomizationDepth(2);
        parameters.scanClasspathForConcreteTypes(true);
        parameters.overrideDefaultInitialization(false);

        EasyRandom generator = new EasyRandom(parameters);

        Person person = generator.nextObject(Person.class);
        System.out.println(person);
    }
}
