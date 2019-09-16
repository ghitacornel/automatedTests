package flyway;

import org.junit.Assert;
import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestFlyway extends TestsSetUp {

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

        Assert.assertEquals(ints, Arrays.asList(1, 2, 3));
        Assert.assertEquals(strings, Arrays.asList("d1", "d2", null));

    }
}
