package in.demo;

public class BankLoanServiceImpl implements BankLoanService {

	@Override
	public float calculateIntrest(float p, float r, float t) {
		float intrestAmount = 0.0f;
		if (p <= 0 || r <= 0 || t <= 0) {
			intrestAmount = (p * r * t) / 100;
		}
		return intrestAmount;
	}

}
