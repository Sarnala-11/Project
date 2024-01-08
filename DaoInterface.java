package com.example.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Entity.Doctor;


@Repository
public interface DaoInterface extends JpaRepository<Doctor, Integer>
{
	Optional<Doctor> findOneByUsernameAndPassword(String username, String password);
	Doctor findByUsername(String username);
}
