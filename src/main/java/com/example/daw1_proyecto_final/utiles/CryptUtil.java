package com.example.daw1_proyecto_final.utiles;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptUtil {

    public static void main(String[] args) {

        BCryptPasswordEncoder bcrypt = new BCryptPasswordEncoder();
        String password = "123456";
        String hash = bcrypt.encode(password);
        System.out.println(hash);

    }

}