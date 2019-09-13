package dbunit.test;

import dbunit.service.Service;
import org.dbunit.DefaultDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class TestsSetUp {

    // database connection is reused by each test
    static Connection databaseConnection;

    // needed only for assertions
    static DefaultDatabaseTester tester;

    /**
     * setup database connection, database initial state and tester
     */
    @BeforeClass
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

    @AfterClass
    public static void tearDown() throws SQLException {
        if (databaseConnection != null) {
            databaseConnection.close();
        }
    }

    protected Service service;

    @Before
    final public void setUpService() {
        service = new Service(databaseConnection);
    }

    // for transactional tests
    @Before
    final public void setUpConnectionTransaction() throws SQLException {
        databaseConnection.setAutoCommit(false);
    }

    // for transactional tests
    @After
    final public void tearDownConnectionTransaction() throws SQLException {
        databaseConnection.rollback();
    }
}