package com.cengizhanyavuz.security.jwttoken.dto;

public record AuthRequest (
        String username,
        String password
){
}