package br.com.santander.agenda.controller.config.security;

public class LoginDto {

	private String email;
	private String password;

	public LoginDto(String email, String password) {
		this.email = email;
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	@Override
	public String toString() {
		return "LoginDto [email=" + email + ", password=" + password + "]";
	}
	
	
}
