package com.example.daw1_proyecto_final.service;


import com.example.daw1_proyecto_final.dto.UserDetailDto;
import com.example.daw1_proyecto_final.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<UserDto> getAllUsers() throws Exception;

    Optional<UserDetailDto> getUserById(int id) throws Exception;

    boolean updateUser(UserDto userDto) throws Exception;

    boolean deleteUserById(int id) throws Exception;

    boolean addUser(UserDetailDto userDetailDto) throws Exception;

}