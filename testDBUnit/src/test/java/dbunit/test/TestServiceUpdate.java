package dbunit.test;

import dbunit.model.Bean;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.ITable;
import org.dbunit.dataset.xml.FlatXmlDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.dbunit.Assertion.assertEquals;

public class TestServiceUpdate extends TestsSetUp {

    private static final String DATABASE_REQUIRED = "databaseRequiredByUpdate.xml";
    private static final String DATABASE_EXPECTED = "databaseExpectedAfterUpdate.xml";

    @BeforeEach
    public void setupDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceUpdate.class.getResourceAsStream(DATABASE_REQUIRED));
        DatabaseOperation.CLEAN_INSERT.execute(tester.getConnection(), dataSet);
    }

    /**
     * can test that update works by using a debugger and checking the actual
     * database state between different test phases
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
            IDataSet expectedDataSet = new FlatXmlDataSetBuilder().build(TestServiceDelete.class.getResourceAsStream(DATABASE_EXPECTED));
            ITable expectedTable = expectedDataSet.getTable("testtable");

            // Assert actual database table match expected table
            assertEquals(expectedTable, actualTable);

        }

    }

    @AfterEach
    public void tearDownDatabaseToInitialState() throws Exception {
        FlatXmlDataSet dataSet = new FlatXmlDataSetBuilder().build(TestServiceUpdate.class.getResourceAsStream(DATABASE_REQUIRED));
        DatabaseOperation.TRUNCATE_TABLE.execute(tester.getConnection(), dataSet);
    }

}
