package com.ctel.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.ctel.model.User;
import com.ctel.repository.UserRepository;

@Service

public class UserService implements UserDetailsService {
	@Autowired
	UserRepository userRepo;

	@Autowired
	private BCryptPasswordEncoder pwdEncoder;

//save method
	public void insert(User user) {
		// Encode password
		user.setPassword(pwdEncoder.encode(user.getPassword()));
		userRepo.save(user).getUserId();
	}

	public List<User> findAll() {
		return userRepo.findAll();

	}

	public Optional<User> getUser(int userId) {
		return userRepo.findById(userId);

	}

	public User update(User user) {
		userRepo.deleteById(user.getUserId());
		return userRepo.save(user);
	}

	public void delete(int userId) {

		userRepo.deleteById(userId);

	}
	@Override
	public UserDetails loadUserByUsername(String emailId) throws UsernameNotFoundException {
		Optional<User> opt = userRepo.findByEmailId(emailId);
		System.out.println(opt);
		if (opt.isEmpty())
			throw new UsernameNotFoundException("User not exist");

		// read user (from DB)
		User user = opt.get();
		return new org.springframework.security.core.userdetails.User(emailId, user.getPassword(),
				user.getRoles().stream().map(role -> new SimpleGrantedAuthority("role")).collect(Collectors.toList()));
	}

}
