package br.com.santander.agenda.config.security;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class TokenService {

	@Value("${jwt.token.secret}")
	private String secret;
	@Value("${jwt.token.expiration}")
	private int expirationTime;

	public String getToken(Authentication authentication) {
		Date issueAt = new Date();
		Date exp = new Date(issueAt.getTime() + expirationTime);
		return Jwts.builder().setIssuer("Agenda").setIssuedAt(issueAt).setExpiration(exp)
				.setSubject(authentication.getName()).signWith(SignatureAlgorithm.HS512, secret).compact();
	}

	public boolean isValidToken(String token) {
		try {
			Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public String getUserEmail(String token) {
		Claims claims = Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody();
		return claims.getSubject();
	}
}
