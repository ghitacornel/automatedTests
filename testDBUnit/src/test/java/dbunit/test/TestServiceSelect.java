package dbunit.test;

import dbunit.model.Bean;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestServiceSelect extends TestsSetUp {

    private static final String DATABASE_REQUIRED = "databaseRequiredBySelect.xml";

    @Before
    public void setupDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceSelect.class.getResourceAsStream(DATABASE_REQUIRED));
        DatabaseOperation.CLEAN_INSERT.execute(tester.getConnection(), dataSet);
    }

    /**
     * can test that select works by using a debugger and checking the actual
     * database state between different test phases
     */
    @Test
    public void testSelect() throws Exception {

        Bean existingBean = service.findById((long) 1);

        // verify data fetched from model with our data.
        // this operation can be very complex.
        {
            Assert.assertEquals(Long.valueOf(1), existingBean.getId());
            Assert.assertEquals("descriere", existingBean.getDescription());
        }

    }

    @After
    public void tearDownDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceSelect.class.getResourceAsStream(DATABASE_REQUIRED));
        DatabaseOperation.TRUNCATE_TABLE.execute(tester.getConnection(), dataSet);
    }

}
