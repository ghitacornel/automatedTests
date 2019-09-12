package dbunit.test;

import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import dbunit.model.Bean;
import dbunit.service.Service;

public class TestServiceSelect extends TestsSetUp {

    private Service service;

    @Before
    public void setUpService() {
        service = new Service(databaseConnection);
    }

    @Before
    public void setupDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceSelect.class.getResourceAsStream("databaseRequiredBySelect.xml"));
        DatabaseOperation.CLEAN_INSERT.execute(tester.getConnection(), dataSet);
    }

    /**
     * can test that select works by using a debugger and checking the actual
     * database state between different test phases
     *
     * @throws Exception
     */
    @Test
    public void testSelect() throws Exception {

        Bean existingBean = service.findById((long) 1);

        // verify data fetched from model with our data.
        // this operation can be very complex.
        {
            Assert.assertEquals(new Long(1), existingBean.getId());
            Assert.assertEquals("descriere", existingBean.getDescription());
        }

    }

    @After
    public void tearDownDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceSelect.class.getResourceAsStream("databaseRequiredBySelect.xml"));
        DatabaseOperation.TRUNCATE_TABLE.execute(tester.getConnection(), dataSet);
    }

}
