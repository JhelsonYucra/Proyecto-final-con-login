package com.example.daw1_proyecto_final.response;


import com.example.daw1_proyecto_final.dto.UserDetailDto;

public record FindUserResponse(String code,
                               String error,
                               UserDetailDto user) {

}