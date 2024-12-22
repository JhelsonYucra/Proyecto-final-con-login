package com.example.daw1_proyecto_final.repository;

import com.example.daw1_proyecto_final.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}