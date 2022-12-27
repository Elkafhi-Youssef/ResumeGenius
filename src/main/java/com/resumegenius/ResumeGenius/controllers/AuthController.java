package com.resumegenius.ResumeGenius.controllers;

<<<<<<< HEAD
import com.resumegenius.ResumeGenius.requests.PersonRequest;
=======
import com.resumegenius.ResumeGenius.requests.UserRequest;
>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
import com.resumegenius.ResumeGenius.security.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtUtil jwtUtil;
<<<<<<< HEAD
    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody PersonRequest request) {
=======

    @PostMapping("/authenticate")
    public ResponseEntity<String> authenticate(@RequestBody UserRequest request) {
>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7

        System.out.println("here");
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );

        final UserDetails user = userDetailsService.loadUserByUsername(request.getEmail());

<<<<<<< HEAD

=======
>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
        if (user != null) {
            return ResponseEntity.ok(jwtUtil.generateToken(user));
        }
        return ResponseEntity.status(400).body("error occurred");
    }

<<<<<<< HEAD
}
=======
}
>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
