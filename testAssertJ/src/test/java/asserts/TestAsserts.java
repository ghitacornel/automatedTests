package asserts;

import model.Dog;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.withPrecision;
import static org.assertj.core.data.MapEntry.entry;

public class TestAsserts {

    @Rule
    public TemporaryFolder temporaryFolderRule = new TemporaryFolder();

    @Test
    public void testAsserts() throws Exception {

        {

            Assertions.assertThat(true).isTrue();
            Assertions.assertThat(false).isFalse();

        }

        {

            Assertions.assertThat(1).isEqualTo(1);
            Assertions.assertThat(2).isNotEqualTo(3);
            Assertions.assertThat(4).isPositive();
            Assertions.assertThat(-4).isNotPositive();
            Assertions.assertThat(-5).isNegative();
            Assertions.assertThat(6).isNotNegative();
            Assertions.assertThat(0).isZero();
            Assertions.assertThat(7).isNotZero();
            assertThat(5.1).isEqualTo(5, withPrecision(1d));

        }

        {

            Object o1 = null;
            Assertions.assertThat(o1).isNull();

            Object o2 = new Object();
            Assertions.assertThat(o2).isNotNull();

            Object o3 = new Object();
            Object o4 = o3;
            Assertions.assertThat(o3).isSameAs(o4);

            Object o5 = new Object();
            Object o6 = new Object();
            Assertions.assertThat(o5).isNotSameAs(o6);

            Dog fido = new Dog("Fido", 5.25);
            Dog fidosClone = new Dog("Fido", 5.25);
            assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidosClone);

        }

        {
            List<String> list = Arrays.asList("1", "2", "3");
            assertThat(list).contains("1");
            assertThat(list).isNotEmpty();
            assertThat(list).startsWith("1");
            assertThat(list)
                    .isNotEmpty()
                    .contains("1")
                    .doesNotContainNull()
                    .containsSequence("2", "3");

            Map<Integer, String> map = new HashMap<>();
            map.put(2, "a");
            assertThat(map)
                    .isNotEmpty()
                    .containsKey(2)
                    .doesNotContainKeys(10)
                    .contains(entry(2, "a"));

            List<String> list1 = Arrays.asList("1", "2", "3");
            List<String> list2 = Arrays.asList("2", "1", "3");
            assertThat(list1).containsAll(list2);
            assertThat(list2).containsAll(list1);

        }

        {
            char someCharacter = 'x';
            assertThat(someCharacter)
                    .isNotEqualTo('a')
                    .inUnicode()
                    .isGreaterThanOrEqualTo('b')
                    .isLowerCase();
        }

        {
            assertThat(Runnable.class).isInterface();
            assertThat(Exception.class).isAssignableFrom(NoSuchElementException.class);
        }

        {
            File temporaryFile = temporaryFolderRule.newFile("temporaryFile.txt");
            assertThat(temporaryFile)
                    .exists()
                    .isFile()
                    .canRead()
                    .canWrite();
        }

    }
}
