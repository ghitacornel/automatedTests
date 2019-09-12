package easymock.test;

import org.easymock.EasyMock;
import org.junit.Assert;
import org.junit.Test;

import easymock.dao.DAO;
import easymock.model.Model;
import easymock.service.Service;

public class Service1Test {

	Service service = new Service();

	/**
	 * we'll need to mock a dao for our tests<br>
	 * usually all class dependencies will be mocked<br>
	 * in our example we will mock an interface though it's possible to mock
	 * even concrete classes
	 */
	DAO mockedDao;

	@Test
	public void test1findById() throws Exception {

		// and now the fun begins :D

		// well that constructor for service is not enough.
		// the service instance now has and will use a null dao.
		// and maybe i cannot build a concrete dao since the actual
		// implementation is known only at runtime

		// so how can I build a valid test context ????????????????
		// well the answer might be => I can't
		// and again maybe i don't need a concrete test context
		// a mocked one might suffice

		mockedDao = EasyMock.createNiceMock(DAO.class);
		// a nice mock will return null when called by default

		service.setDao(mockedDao);

		// test our business on a mock model; mocked but concrete one
		Model model = service.findById(1);

		// to our surprise this test passes.
		// the mock will return null when invoked.
		Assert.assertNull(model);

		// XXX note that order of invocation is irrelevant
		// XXX note that we mock a method in dao to return something
	}
}
