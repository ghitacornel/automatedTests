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

public class TestServiceUpdate extends TestsSetUp {

    private Service service;

    @Before
    public void setUpService() {
        service = new Service(databaseConnection);
    }

    @Before
    public void setupDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceUpdate.class.getResourceAsStream("databaseRequiredByUpdate.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(tester.getConnection(), dataSet);
    }

    /**
     * can test that update works by using a debugger and checking the actual
     * database state between different test phases
     *
     * @throws Exception
     */
    @Test
    public void testUpdate() throws Exception {

        // executing our code
        {
            Bean bean = new Bean();
            bean.setId(1L);
            bean.setDescription("descriere2");

            service.update(bean);
        }

        // verify database state
        {

            // Fetch database data after executing your code
            IDataSet databaseDataSet = tester.getConnection().createDataSet();
            ITable actualTable = databaseDataSet.getTable("testtable");

            // Load expected data from an XML dataset
            IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(TestServiceDelete.class.getResourceAsStream("databaseExpectedAfterUpdate.xml"));
            ITable expectedTable = expectedDataSet.getTable("testtable");

            // Assert actual database table match expected table
            Assertion.assertEquals(expectedTable, actualTable);

        }

    }

    @After
    public void tearDownDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceUpdate.class.getResourceAsStream("databaseRequiredByUpdate.xml"));
        DatabaseOperation.TRUNCATE_TABLE.execute(tester.getConnection(), dataSet);
    }

}
