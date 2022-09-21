package utils;

public class SignInData {
	
	private String expectedTitle;
	private String expectedUrl;
	private String email;
	private String passward;
	
	public SignInData(String expectedTitle, String expectedUrl, String email, String passward) {
		this.expectedTitle = expectedTitle;
		this.expectedUrl = expectedUrl;
		this.email = email;
		this.passward = passward;
	}

	public String getExpectedTitle() {
		return expectedTitle;
	}

	public String getExpectedUrl() {
		return expectedUrl;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return passward;
	}

}
