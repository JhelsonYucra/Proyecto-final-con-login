package com.example.daw1_proyecto_final.response;


import com.example.daw1_proyecto_final.dto.UserDto;

public record FindUsersResponse(String code,
                                String error,
                                Iterable<UserDto> users) {

}