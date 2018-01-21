package mockito.in.solution.service;

import mockito.in.solution.DAO.LoginDAO;

public class LoginServiceImpl implements LoginService {

	private LoginDAO dao;

	public void setDAO(LoginDAO dao) {
		this.dao = dao;
	}

	public boolean authenticate(String user, String password) {
		
		if (user.equals("") || password.equals(""))
			throw new IllegalArgumentException("provide proper inputs");
		int count = dao.verify(user, password);
		if (count == 0)
			return false;
		else
			return true;
	}

}
