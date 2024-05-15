package registration.util;

import jakarta.servlet.http.HttpServletRequest;
import registration.constants.RegisterConstants;

public class RegisterUtil {
	
	public static String validateRequest(HttpServletRequest request) {
		
		String error = null;
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		if (firstName.isEmpty() || lastName.isEmpty() || userName.isEmpty()||  password.isEmpty()) {
			error = RegisterConstants.EMPTY_FIELD;
		}
		return error;
	}

}
