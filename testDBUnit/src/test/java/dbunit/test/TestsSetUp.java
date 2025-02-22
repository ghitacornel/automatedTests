package dbunit.test;

import dbunit.service.Service;
import org.dbunit.DefaultDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class TestsSetUp {

    // needed only for assertions
    static DefaultDatabaseTester tester;
    // database connection is reused by each test
    private static Connection databaseConnection;
    Service service;

    /**
     * setup database connection, database initial state and tester
     */
    @BeforeAll
    public static void setUp() throws Exception {

        // set up connection
        // usually a data source is better
        {
            Class.forName("org.hsqldb.jdbcDriver");
            databaseConnection = DriverManager.getConnection("jdbc:hsqldb:mem:testdb", "", "");
        }

        // set up helper
        // many custom testers are available
        {
            DatabaseConnection databaseConnection = new DatabaseConnection(TestsSetUp.databaseConnection);
            databaseConnection.getConfig().setProperty(DatabaseConfig.PROPERTY_DATATYPE_FACTORY, new HsqldbDataTypeFactory());
            tester = new DefaultDatabaseTester(databaseConnection);
        }

        {// create database schema
            databaseConnection.createStatement().execute("drop table if exists testtable;");
            databaseConnection.createStatement().execute("create table testtable(id int primary key, description varchar(50));");
        }

    }

    @AfterAll
    public static void tearDown() throws SQLException {
        if (databaseConnection != null) {
            databaseConnection.close();
        }
    }

    @BeforeEach
    final public void setUpService() {
        service = new Service(databaseConnection);
    }

    // for transactional tests
    @BeforeEach
    final public void setUpConnectionTransaction() throws SQLException {
        databaseConnection.setAutoCommit(false);
    }

    // for transactional tests
    @AfterEach
    final public void tearDownConnectionTransaction() throws SQLException {
        databaseConnection.rollback();
    }
}