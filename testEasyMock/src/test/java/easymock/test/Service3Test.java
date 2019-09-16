package easymock.test;

import easymock.dao.DAO;
import easymock.model.Model;
import easymock.service.Service;
import org.easymock.*;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

@RunWith(EasyMockRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Service3Test {

    // see this nice annotation
    // easy mock will inject mocks into it
    @TestSubject
    Service service = new Service();

    // this mock will be injected into the subject of the test
    @Mock
    DAO mockedDao;

    /**
     * try to test the insert work flow<br>
     *
     * @throws Exception
     */
    @Test
    public void test5InsertWorkflow() throws Exception {

        // now we really need to capture the model right before insert
        Capture<Model> captureModel = Capture.newInstance();
        {
            EasyMock.expect(mockedDao.findById(1)).andReturn(null);
            mockedDao.insert(EasyMock.capture(captureModel));
            EasyMock.replay(mockedDao);
        }

        Model model = buildTestData();
        service.business(model);

        // finally test mock
        EasyMock.verify(mockedDao);

        // test model changes
        Assert.assertEquals(1, model.getId());
        Assert.assertEquals("descriere new", model.getDescription());

        // and verify captured model changes
        Assert.assertEquals(model.getId(), captureModel.getValue().getId());
        Assert.assertEquals(model.getDescription(), captureModel.getValue()
                .getDescription());

        // XXX
        // from this test we learn how to :
        // build a mock.
        // set up expectations of method order calls to mock.
        // capture parameters of methods called on mock.
        // reset/replay/verify the mock
        // verify the captures at the end of it
        // easy mock will verify for us method calls and order of calls

        // XXX try to see the mock as a recorder/player
        // it will record your actions on it starting from the first call of a
        // method on it
        // it expects you to tell him when to reset
        // or when to stop recording and entering in the replay mode.
        // in replay mode the mock expects calls to him, calls executed
        // identically with the recorded work flow.
        // in replay mode any unexpected call to a mock method is an error.
        // in replay mode any call to a mock method with not expected parameters
        // is an error.
        // if all went fine the verify on mock should succeed.
        // captures can be seen as side products of mock calls, products that
        // can be further tested

        // XXX easy mock can verify if 2 threads accessed the same mock
        // concurrently or can make a mock behave 'synchronized'

    }

    /**
     * try to test the update work flow<br>
     *
     * @throws Exception
     */
    @Test
    public void test6UpdateWorkflow() throws Exception {

        // now we really need to capture the model right before update
        Capture<Model> captureModel = Capture.newInstance();
        {
            EasyMock.expect(mockedDao.findById(1)).andReturn(new Model());
            mockedDao.update(EasyMock.capture(captureModel));
            EasyMock.replay(mockedDao);
        }

        Model model = buildTestData();
        service.business(model);

        // finally test mock
        EasyMock.verify(mockedDao);

        // test model changes
        Assert.assertEquals(1, model.getId());
        Assert.assertEquals("descriere existing", model.getDescription());

        // and verify captured model changes
        Assert.assertEquals(model.getId(), captureModel.getValue().getId());
        Assert.assertEquals(model.getDescription(), captureModel.getValue()
                .getDescription());

    }

    /**
     * try to test the insert work flow with exception raised by dao<br>
     *
     * @throws Exception
     */
    @Test(expected = Exception.class)
    public void test7InsertWithExceptionWorkflow() throws Exception {

        // try to capture here all parameters send to mock calls
        Capture<Integer> captureId = Capture.newInstance();
        Capture<Model> captureModel = Capture.newInstance();
        {
            EasyMock.expect(mockedDao.findById(EasyMock.captureInt(captureId)))
                    .andReturn(null);
            mockedDao.insert(EasyMock.capture(captureModel));
            EasyMock.expectLastCall().andThrow(new Exception());
            EasyMock.replay(mockedDao);
        }

        Model model = buildTestData();

        try {

            // will raise exception for sure
            service.business(model);

        } finally {

            // finally test mock
            EasyMock.verify(mockedDao);

            // test model changes
            Assert.assertEquals(1, model.getId());
            Assert.assertEquals("descriere new", model.getDescription());

            // but don't forget to verify parameters send to mock methods
            Assert.assertEquals(1, captureId.getValue().intValue());

            // and verify captured model changes
            Assert.assertEquals(model.getId(), captureModel.getValue().getId());
            Assert.assertEquals(model.getDescription(), captureModel.getValue()
                    .getDescription());

        }

    }

    /**
     * try to test the insert work flow without captures<br>
     * {@link Capture} is useful when certain model parts are created and used
     * during business work flow.<br>
     * We can capture their usage and test them better.<br>
     * Otherwise easy mock will test automatically for us if the supplied
     * parameters are also those received by the mock during execution
     *
     * @throws Exception
     */
    @Test
    public void test8InsertWorkflowNoCaptures() throws Exception {

        Model model = buildTestData();
        {
            EasyMock.expect(mockedDao.findById(1)).andReturn(null);
            mockedDao.insert(model);
            EasyMock.replay(mockedDao);
        }

        // and now invoke our business
        service.business(model);

        // finally test mock
        EasyMock.verify(mockedDao);

        // test model changes
        Assert.assertEquals(1, model.getId());
        Assert.assertEquals("descriere new", model.getDescription());

    }

    private Model buildTestData() {
        Model model = new Model();
        model.setId(1);
        model.setDescription("descriere");
        return model;
    }
}
