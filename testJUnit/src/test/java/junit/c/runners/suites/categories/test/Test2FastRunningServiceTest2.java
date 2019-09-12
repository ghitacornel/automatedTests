package junit.c.runners.suites.categories.test;

import junit.c.runners.suites.categories.ServiceC;

import org.junit.Test;
import org.junit.experimental.categories.Category;

public class Test2FastRunningServiceTest2 {

	@Category(OddCategory.class)
	@Test
	public void test1fastRunningFlow3() {
		new ServiceC().fastRunningBusiness();
	}

	@Category(EvenCategory.class)
	@Test
	public void test2fastRunningFlow4() {
		new ServiceC().fastRunningBusiness();
	}

}
