package assignment_3;

class UserRegistration {
	
	public void registerUser(String username,String userCountry)
			throws InvalidCountryException {
		if(userCountry.equals("india")) {
			System.out.println("successful registration of user");
		}else
			throw new InvalidCountryException("invalid country name : "+
		userCountry+" please provide india");
	}
}

class InvalidCountryException extends Exception {
	private static final long serialVersionUID = 1L;

	public InvalidCountryException(String message) {
		super(message);
	}
}

public class Q5 {

	public static void main(String[] args) {

		UserRegistration registration=new UserRegistration();
		
		try {
			registration.registerUser("raj", "usa");
		} catch (InvalidCountryException e) {
			System.out.println(e.getMessage());
		}
	}
}
