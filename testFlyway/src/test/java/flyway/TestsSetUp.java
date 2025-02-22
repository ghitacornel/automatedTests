package flyway;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.flywaydb.core.Flyway;
import org.junit.jupiter.api.BeforeEach;

import javax.sql.DataSource;

public abstract class TestsSetUp {

    Flyway flyway;

    /**
     * setup database connection, database initial state and tester
     */
    @BeforeEach
    final public void setUpFlyway() {

        flyway = Flyway.configure()
                .cleanDisabled(false)
                .dataSource(dataSource())
                .locations("patches")// location of patch files
                .baselineVersion("0")// default is 1 and collides with the patch scripts staring version
                .outOfOrder(true)// allow for execution of new scripts added "in the middle of" others
                .load();

        flyway.clean();
        flyway.migrate();

    }

    private DataSource dataSource() {
        return new HikariDataSource(hikariConfig());
    }

    private HikariConfig hikariConfig() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.hsqldb.jdbc.JDBCDriver");
        config.setJdbcUrl("jdbc:hsqldb:mem:testdb");
        config.setUsername("");
        config.setPassword("");
        return config;
    }

}