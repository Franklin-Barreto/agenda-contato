package br.com.santander.agenda.config.security;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import br.com.santander.agenda.model.User;
import br.com.santander.agenda.service.UserService;

public class JwtTokenFilter extends OncePerRequestFilter {

	private final TokenService tokenService;
	private final UserService userService;

	public JwtTokenFilter(TokenService tokenService, UserService userService) {
		this.tokenService = tokenService;
		this.userService = userService;
	}

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token = retriveToken(request);
		if (tokenService.isValidToken(token)) {
			authenticate(token);
		}
		filterChain.doFilter(request, response);
	}

	private String retriveToken(HttpServletRequest request) {
		String token = request.getHeader("Authorization");
		if (token == null || token.isEmpty() || !token.startsWith("Bearer ")) {
			return null;
		}
		return token.substring(7);
	}

	private void authenticate(String token) {
		String email = tokenService.getUserEmail(token);
		Optional<User> opUser = userService.findUserByEmail(email);
		if (opUser.isPresent()) {
			User user = opUser.get();
			UsernamePasswordAuthenticationToken authenticate = new UsernamePasswordAuthenticationToken(user, null,
					user.getRoles());
			SecurityContext context = SecurityContextHolder.createEmptyContext();
			context.setAuthentication(authenticate);
			SecurityContextHolder.setContext(context);
		}
	}

}
