/**
 * 
 */
package in.demo.test;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;

import in.demo.BankLoanService;
import in.demo.BankLoanServiceImpl;

/**
 * @author Naman
 *
 */
public class Test {

	private static BankLoanService service;

	/**
	 * @throws java.lang.Exception
	 */
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setUpBeforeClass");
		service = new BankLoanServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass");
		service = new BankLoanServiceImpl();
	}

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		System.out.println("setUp");
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
		System.out.println("tearDown");
	}

	/**
	 * Test method for
	 * {@link in.demo.BankLoanServiceImpl#calculateIntrest(float, float, float)}.
	 */
	@org.junit.Test
	public void testCalculateIntrestInt() {
		int p = 1000;
		int r = 2;
		int t = 20;
		int expectedAmount = 4000;
		int actualAmount =3999;
		float intrestAmount = service.calculateIntrest(p, r, t);
		assertEquals("Result1", expectedAmount, actualAmount, 1);
	}

	@org.junit.Test
	public void testCalculateIntrestFloat() {
		float p = 1000.0f;
		float r = 2.0f;
		float t = 20.0f;
		float expectedAmount = 3999.5f;
		float actualAmount = 4000.0f;
		float intrestAmount = service.calculateIntrest(p, r, t);
		assertEquals("Result2", expectedAmount, actualAmount, 10.10f);
	}
	@org.junit.Test
	public void testCalculateIntrestZero() {
		float expectedAmount=0.0f;
		float actualAmount = 0.0f;
		float intrestAmount = service.calculateIntrest(0.0f, 0.0f, 0.0f);
		assertEquals("Result2", expectedAmount, actualAmount, 0.1f);
	}

}
