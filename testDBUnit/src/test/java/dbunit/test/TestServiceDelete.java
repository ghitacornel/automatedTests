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

public class TestServiceDelete extends TestsSetUp {

    private Service service;

    @Before
    public void setUpService() {
        service = new Service(databaseConnection);
    }

    @Before
    public void setupDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceDelete.class.getResourceAsStream("databaseRequiredByDelete.xml"));
        DatabaseOperation.TRUNCATE_TABLE.execute(tester.getConnection(), dataSet);
    }

    /**
     * can test that delete works by using a debugger and checking the actual
     * database state between different test phases
     *
     * @throws Exception
     */
    @Test
    public void testDelete() throws Exception {

        // executing our code
        {
            Bean bean = new Bean();
            bean.setId(1L);
            service.delete(bean);
        }

        // verify database state
        {

            // Fetch database data after executing your code
            IDataSet databaseDataSet = tester.getConnection().createDataSet();
            ITable actualTable = databaseDataSet.getTable("testtable");

            // Load expected data from an XML dataset
            IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(TestServiceDelete.class.getResourceAsStream("databaseExpectedAfterDelete.xml"));
            ITable expectedTable = expectedDataSet.getTable("testtable");

            // Assert actual database table match expected table
            Assertion.assertEquals(expectedTable, actualTable);

        }

    }

    @After
    public void tearDownDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceDelete.class.getResourceAsStream("databaseExpectedAfterDelete.xml"));
        DatabaseOperation.TRUNCATE_TABLE.execute(tester.getConnection(), dataSet);
    }

}
