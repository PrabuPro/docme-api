package com.docme.docmeapi.controller;

import com.docme.docmeapi.dto.UserDto;
import com.docme.docmeapi.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/login")
@RequiredArgsConstructor
public class LoginController {


    final private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDto> signupUser(@Valid @RequestBody UserDto userDto){
        UserDto savedUserDto = userService.saveUser(userDto);
        return new  ResponseEntity<>(userDto, HttpStatus.CREATED);
    }


    @GetMapping("/hello")
    @PreAuthorize("hasRole('client_user')")
    public String login(){
        return "welcome - hello";
    }

    @GetMapping("/hello2")
    @PreAuthorize("hasRole('client_admin')")
    public String login2(){
        return "welcome - hello2";
    }
}
