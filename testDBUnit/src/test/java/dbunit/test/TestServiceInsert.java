package dbunit.test;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import dbunit.model.Bean;
import dbunit.service.Service;

public class TestServiceInsert extends TestsSetUp {

    private Service service;

    @Before
    public void setUpService() {
        service = new Service(databaseConnection);
    }

    @Before
    public void setupDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceInsert.class.getResourceAsStream("databaseRequiredByInsert.xml"));
        DatabaseOperation.TRUNCATE_TABLE.execute(tester.getConnection(), dataSet);
    }

    /**
     * can test that insert works by using a debugger and checking the actual
     * database state between different test phases
     *
     * @throws Exception
     */
    @Test
    public void testInsert() throws Exception {

        // executing our code
        {

            Bean bean = new Bean();
            bean.setId(1L);
            bean.setDescription("descriere");

            service.insert(bean);

        }

        // verify database state
        {

            // Fetch database data after executing your code
            IDataSet databaseDataSet = tester.getConnection().createDataSet();
            ITable actualTable = databaseDataSet.getTable("testtable");

            // Load expected data from an XML dataset
            IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(TestServiceInsert.class.getResourceAsStream("databaseExpectedAfterInsert.xml"));
            ITable expectedTable = expectedDataSet.getTable("testtable");

            // Assert actual database table match expected table
            Assertion.assertEquals(expectedTable, actualTable);

        }

    }

    @After
    public void tearDownDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceInsert.class.getResourceAsStream("databaseRequiredByInsert.xml"));
        DatabaseOperation.TRUNCATE_TABLE.execute(tester.getConnection(), dataSet);
    }

}
