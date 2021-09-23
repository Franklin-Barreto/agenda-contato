package br.com.santander.agenda.config.security;

public class TokenDto {

	String token;
	String type;
	
	public TokenDto(String token, String type) {
		this.token = token;
		this.type = type;
	}

	public String getToken() {
		return token;
	}
	
	public String getType() {
		return type;
	}
}
