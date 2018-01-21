package mockito.in.solution.mockito;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

import mockito.in.solution.DAO.LoginDAO;
import mockito.in.solution.service.LoginService;
import mockito.in.solution.service.LoginServiceImpl;

public class LoginTest {

	private static LoginDAO mockDAO;
	private static LoginService service;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		mockDAO = Mockito.mock(LoginDAO.class);
		service = new LoginServiceImpl();
		((LoginServiceImpl) service).setDAO(mockDAO);

	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		mockDAO=null;
		service=null;
	}

	@Test
	public void testWithValidCredential() {
		boolean status = false;
		Mockito.when(mockDAO.verify("Naman", "Mishra")).thenReturn(1);
		status = service.authenticate("Naman", "Mishra");
		assertTrue(status);
	}

	@Test
	public void testWithInValidCredential() {
		boolean status = false;
		Mockito.when(mockDAO.verify("Shivangi", "Shukla")).thenReturn(0);
		status = service.authenticate("Shivangi", "Shukla");
		assertFalse(status);
	}

	@Test(expected = IllegalArgumentException.class)
	public void testWithNoCredential() {
		boolean status = false;
		status = service.authenticate("", "");
		fail("error is expected, but not raised");
	}
}
