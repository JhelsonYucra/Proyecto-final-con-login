package com.example.daw1_proyecto_final.serviceImplement;

import com.example.daw1_proyecto_final.dto.UserDetailDto;
import com.example.daw1_proyecto_final.dto.UserDto;
import com.example.daw1_proyecto_final.model.User;
import com.example.daw1_proyecto_final.repository.UserRepository;
import com.example.daw1_proyecto_final.service.ManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ManageServiceImpl implements ManageService {

    @Autowired
    UserRepository userRepository;

    @Override
    public List<UserDto> getAllUsers() throws Exception {

        List<UserDto> users = new ArrayList<UserDto>();
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(user -> {
            users.add(new UserDto(user.getId(),
                    user.getEmail(),
                    user.getFirstName(),
                    user.getLastName()));
        });
        return users;

    }

    @Override
    public Optional<UserDetailDto> getUserById(int id) throws Exception {

        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> new UserDetailDto(user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getEmail(),
                user.getFirstName(),
                user.getLastName(),
                user.getRole(),
                user.getCreatedAt(),
                user.getUpdatedAt()));

    }

    @Override
    public boolean updateUser(UserDto userDto) throws Exception {

        Optional<User> optional = userRepository.findById(userDto.id());
        return optional.map(user -> {
            user.setEmail(userDto.email());
            user.setFirstName(userDto.firstName());
            user.setLastName(userDto.lastName());
            user.setUpdatedAt(new Date());
            userRepository.save(user);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean deleteUserById(int id) throws Exception {

        Optional<User> optional = userRepository.findById(id);
        return optional.map(user -> {
            userRepository.delete(user);
            return true;
        }).orElse(false);

    }

    @Override
    public boolean addUser(UserDetailDto userDetailDto) throws Exception {

        Optional<User> optional = userRepository.findById(userDetailDto.id());
        if (optional.isEmpty()) {
            User user = new User();
            user.setUsername(userDetailDto.username());
            user.setPassword(userDetailDto.password());
            user.setEmail(userDetailDto.email());
            user.setFirstName(userDetailDto.firstName());
            user.setLastName(userDetailDto.lastName());
            user.setRole(userDetailDto.role());
            user.setCreatedAt(new Date());
            userRepository.save(user);
            return true;
        }
        return false;

    }

}