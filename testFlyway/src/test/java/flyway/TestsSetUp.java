package flyway;

import org.flywaydb.core.Flyway;
import org.junit.Before;

public abstract class TestsSetUp {

    Flyway flyway;

    /**
     * setup database connection, database initial state and tester
     */
    @Before
    final public void setUpFlyway() {

        flyway = Flyway.
                configure().
                cleanDisabled(false).
                dataSource("jdbc:hsqldb:mem:testdb", "", "").
                locations("patches").// location of patch files
                baselineVersion("0").// default is 1 and collides with the patch scripts staring version
                outOfOrder(true).// allow for execution of new scripts added "in the middle of" others
                load();

        flyway.clean();
        flyway.migrate();

    }

}