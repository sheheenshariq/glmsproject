package glms.dto;

public class LoginDTO {
	String Username,AccountNumber;
	String Password;

	public String getAccountNumber() {
		return AccountNumber;
	}
    public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getUsername() {
		return Username;
	}
    public void setUsername(String username) {
		Username = username;
	}

	public String getPassword() {
		return Password;
	}
    public void setPassword(String password) {
		Password = password;
	}
}
