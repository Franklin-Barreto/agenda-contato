package br.com.santander.agenda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.santander.agenda.config.security.TokenService;
import br.com.santander.agenda.controller.config.security.LoginDto;
import br.com.santander.agenda.controller.config.security.TokenDto;

@RestController
@RequestMapping("auth")
public class AuthController {

	@Autowired
	AuthenticationManager authenticationManager; 
	
	@Autowired
	private TokenService tokenService;
	
	@PostMapping
	public ResponseEntity<TokenDto> authenticate(@RequestBody LoginDto loginDto) {
		Authentication authentication = new UsernamePasswordAuthenticationToken(loginDto.getEmail(), loginDto.getPassword());
		Authentication authenticate = authenticationManager.authenticate(authentication);
		String token = tokenService.getToken(authenticate);
		return ResponseEntity.ok(new TokenDto(token,"Bearer"));
	}
}
