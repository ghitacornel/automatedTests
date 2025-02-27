package flyway;

import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestFlywayA extends TestsSetUp {

    @BeforeEach
    final public void setUpFlywayForThisTest() {

        flyway = Flyway.
                configure().
                dataSource("jdbc:hsqldb:mem:testdb", "", "").
                locations("patches", "testA").// location of patch files
                        baselineVersion("0").// default is 1 and collides with the patch scripts staring version
                        outOfOrder(true).// allow for execution of new scripts added "in the middle of" others
                        load();

        flyway.migrate();

    }

    @Test
    public void testIt() throws Exception {

        List<Integer> ints = new ArrayList<>();
        List<String> strings = new ArrayList<>();

        {// get data
            Connection connection = flyway.getConfiguration().getDataSource().getConnection();
            ResultSet resultSet = connection.createStatement().executeQuery("select * from testtable");
            while (resultSet.next()) {
                int anInt = resultSet.getInt(1);
                ints.add(anInt);
                String aString = resultSet.getString(2);
                strings.add(aString);
            }
            connection.close();
        }

        assertEquals(ints, Arrays.asList(1, 2, 3, 4));
        assertEquals(strings, Arrays.asList("d1", "d2", null, "d4_for_A"));

    }
}
