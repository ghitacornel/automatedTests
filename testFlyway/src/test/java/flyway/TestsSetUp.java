package flyway;

import org.flywaydb.core.Flyway;
import org.junit.Before;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class TestsSetUp {

    Flyway flyway;

    /**
     * setup database connection, database initial state and tester
     */
    @Before
    final public void setUpFlyway() throws Exception {

        {// better logging
            System.setProperty(org.slf4j.impl.SimpleLogger.DEFAULT_LOG_LEVEL_KEY, "DEBUG");
        }

        flyway = Flyway.
                configure().
                dataSource("jdbc:hsqldb:mem:testdb", "", "").
                locations("patches").
                baselineVersion("0").
                load();

        flyway.clean();
        flyway.migrate();

    }

}