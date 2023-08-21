package com.ctel.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ctel.model.User;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> 
{

	User save(int userId);
	
	Optional<User> findByEmailId(String emailId);

}
