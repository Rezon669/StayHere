package com.stayhere.app.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.stayhere.app.model.UserDto;
@Repository
public interface UserRepository extends JpaRepository<UserDto, Long>{

	 Optional<UserDto> findByUsernameOrEmail(String username, String email);

}
