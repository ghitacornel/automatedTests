package dbunit.test;

import dbunit.service.Service;
import org.dbunit.DefaultDatabaseTester;
import org.dbunit.database.DatabaseConfig;
import org.dbunit.database.DatabaseConnection;
import org.dbunit.ext.hsqldb.HsqldbDataTypeFactory;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class TestsSetUp {

    // database connection is reused by each test
    static Connection databaseConnection;

    // needed only for assertions
    static DefaultDatabaseTester tester;

    @BeforeClass
    public static void setUp() throws Exception {

        // set up connections.
        // usually a data source is better
        {
            Class.forName("org.hsqldb.jdbcDriver").newInstance();
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
            databaseConnection.createStatement().execute("insert into testtable(id,description) values (1,'descriere1');");
            databaseConnection.createStatement().execute("insert into testtable(id,description) values (2,'descriere2');");
            databaseConnection.createStatement().execute("insert into testtable(id,description) values (3,null);");
        }

    }

    @AfterClass
    public static void tearDown() throws Exception {
        if (databaseConnection != null) {
            databaseConnection.close();
        }
    }

    protected Service service;

    @Before
    public void setUpService() {
        service = new Service(databaseConnection);
    }

}