package br.com.santander.agenda.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import br.com.santander.agenda.model.User;
import br.com.santander.agenda.repository.UserRepository;

@Service
public class UserService {

	private final UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Optional<User> findUserByEmail(String username) {
		return userRepository.findByEmail(username);
	}
}
