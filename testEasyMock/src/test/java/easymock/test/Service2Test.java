package easymock.test;

import easymock.dao.DAO;
import easymock.model.Model;
import easymock.service.Service;
import org.easymock.Capture;
import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Service2Test {

    Service service;

    /**
     * we'll need to mock a dao for our tests<br>
     * usually all class dependencies will be mocked<br>
     * in our example we will mock an interface though it's possible to mock
     * even concrete classes
     */
    DAO mockedDao;

    @Before
    public void before() {
        service = new Service();

        // a strict mock will have to be manually configured
        // it will record method calls with parameters to it and will expect us
        // to follow the recorded method calls during service test
        mockedDao = EasyMock.createStrictMock(DAO.class);

        service.setDao(mockedDao);
    }

    @Test
    public void test2findByIdWithReturnResult() throws Exception {

        // configure mock to return a model on invocation
        Model model = new Model();
        model.setId(1);
        {
            // clean state of mock
            // this is done here for demo purpose in case of reusing the mock
            EasyMock.reset(mockedDao);

            // record a sequence of calls to mock
            // this sequence of method calls to mock must match the business
            // calls to an original not mocked object
            EasyMock.expect(mockedDao.findById(1)).andReturn(model);

            // mark end of recordings
            EasyMock.replay(mockedDao);
        }

        // test our business on a mock model; mocked but concrete one
        Model returnedModel = service.findById(1);

        // and verify model changes
        Assert.assertEquals(model.getId(), returnedModel.getId());
        Assert.assertEquals(model.getDescription(),
                returnedModel.getDescription());

        // finally test that mock was called
        EasyMock.verify(mockedDao);

        // XXX these kind of tests are very important
        // they allow us to test work flows usually described in UML diagrams

    }

    @Test(expected = Exception.class)
    public void test3findByIdWithExceptionThrown() throws Exception {

        // configure mock to throw an exception
        {
            EasyMock.expect(mockedDao.findById(1)).andThrow(new Exception());
            EasyMock.replay(mockedDao);
        }

        try {
            service.findById(1);
        } catch (Exception e) {
            EasyMock.verify(mockedDao);
            throw e;
        }

    }

    @Test
    public void test4findByIdWithParameterCapture() throws Exception {

        // use a capture to capture the method call parameter to dao
        Capture<Integer> captureId = Capture.newInstance();

        // configure mock to return null but capture parameter
        {
            EasyMock.expect(mockedDao.findById(EasyMock.captureInt(captureId)))
                    .andReturn(null);
            EasyMock.replay(mockedDao);
        }

        service.findById(1);

        EasyMock.verify(mockedDao);

        // we can verify capture to check for expectations.
        // testing mock method calls parameters is done automatically by
        // EasyMock so our capture is just for demo in this case but can be of
        // help for other test scenarios.
        // this proves we can capture all method calls parameters and test them
        // later.
        Assert.assertEquals(1, captureId.getValue().intValue());

    }
}
