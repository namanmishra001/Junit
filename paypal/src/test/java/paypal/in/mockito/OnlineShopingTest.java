package paypal.in.mockito;

import static org.junit.Assert.assertEquals;

import java.util.Date;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import in.paypal.dto.TransactionDetails;
import in.paypal.service.OnlineShoppingServiceImpl;
import in.paypal.service.PayPalService;

public class OnlineShopingTest {
	
	@Mock
	private static PayPalService service;
	
	private OnlineShoppingServiceImpl serviceImpl;
	
	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		 serviceImpl = new OnlineShoppingServiceImpl();
		((OnlineShoppingServiceImpl)serviceImpl).setService(service);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testPaymentWithValidCardNumber() {
		TransactionDetails details = new TransactionDetails();
		details.setCardNumber(1001);
		details.setCardType("visa");
		details.setAmount(3000);
		details.setTxDate(new Date());
		Mockito.when(service.verifyCardNumber(1001)).thenReturn(true);
		Mockito.when(service.doPayment(1001, 3000)).thenReturn(details);
		String actual = serviceImpl.payment(1001, 3000);
		assertEquals("payment done for1001for Amount3000.0using CardTypevisa", actual);
		
	}
	@Test
	public void testPaymentWithInValidCardNumber() {
		Mockito.when(service.verifyCardNumber(1002)).thenReturn(false);
		String actual = serviceImpl.payment(1002, 3000);
		assertEquals("invalid Card Number", actual);
	}
	

}
