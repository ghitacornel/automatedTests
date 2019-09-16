package flyway;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;

public class TestFlyway extends TestsSetUp {

    @Test
    public void testIt() throws Exception {

        flyway.validate();

        Connection connection = flyway.getConfiguration().getDataSource().getConnection();
        ResultSet resultSet = connection.createStatement().executeQuery("select * from testtable");
        while (resultSet.next()) {
            int anInt = resultSet.getInt(1);
            String aString = resultSet.getString(2);
            System.out.println(anInt + " " + aString);
        }
        connection.close();
    }
}
