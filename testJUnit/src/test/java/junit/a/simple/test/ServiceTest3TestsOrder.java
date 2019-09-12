package junit.a.simple.test;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 * The order of test executions should be irrelevant<br>
 * but can be controlled<br>
 * 
 * @author CornelGhita
 * 
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
// try playing with different method order
public class ServiceTest3TestsOrder {

	@Test
	public void test3() {
	}

	@Test
	public void test1() {
	}

	@Test
	public void test2() {
	}

}
