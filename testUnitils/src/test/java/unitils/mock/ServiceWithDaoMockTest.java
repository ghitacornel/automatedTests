package unitils.mock;

import org.easymock.EasyMock;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.unitils.UnitilsJUnit4TestClassRunner;
import org.unitils.easymock.annotation.RegularMock;
import org.unitils.inject.annotation.InjectIntoByType;
import org.unitils.inject.annotation.TestedObject;

@RunWith(UnitilsJUnit4TestClassRunner.class)
public class ServiceWithDaoMockTest {

    @InjectIntoByType
    @RegularMock
    DAO dao;

    @TestedObject
    ServiceWithDao serviceWithDao;

    @Test
    public void test() {

        dao.callDatabase();
        EasyMock.replay(dao);

        serviceWithDao.callDatabase();

        EasyMock.verify(dao);
    }

}
