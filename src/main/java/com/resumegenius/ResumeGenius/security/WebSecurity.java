package com.resumegenius.ResumeGenius.security;


<<<<<<< HEAD
import com.resumegenius.ResumeGenius.entities.AdminEntity;
import com.resumegenius.ResumeGenius.services.impl.PersonServiceimpl;
=======
import com.resumegenius.ResumeGenius.entities.UserEntity;
import com.resumegenius.ResumeGenius.services.impl.UserServiceimpl;
>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.lang.reflect.InvocationTargetException;
import java.util.Collections;

@Configuration
@EnableWebSecurity

public class WebSecurity  {
    private final JwtAuthFilter jwtAuthFilter;
<<<<<<< HEAD
    private final PersonServiceimpl adminService;

    @Autowired
    @Lazy
    public WebSecurity(JwtAuthFilter jwtAuthFilter,  PersonServiceimpl adminService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.adminService = adminService;
    }

=======
    private final UserServiceimpl userService;

    @Autowired
    @Lazy
    public WebSecurity(JwtAuthFilter jwtAuthFilter,  UserServiceimpl userService) {
        this.jwtAuthFilter = jwtAuthFilter;
        this.userService = userService;
    }


>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
<<<<<<< HEAD
                .requestMatchers("/auth/**","/person/**")
=======
                .requestMatchers("/auth/**")
>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(jwtAuthFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }
<<<<<<< HEAD
=======

>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
    @Bean
    public AuthenticationProvider authenticationProvider() {
        final DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
//        return NoOpPasswordEncoder.getInstance();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
<<<<<<< HEAD
                AdminEntity admin = null;
                try {
                    admin = adminService.findPersonByEmail(email);
=======
                UserEntity user = null;
                try {
                    user = userService.findUserByEmail(email);
>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                }
<<<<<<< HEAD
                return new User(admin.getEmail(), admin.getEncryptedPassword(), Collections.singleton(new SimpleGrantedAuthority("user")));
            }
        };
    }
}
=======
                return new User(user.getEmail(), user.getEncryptedPassword(), Collections.singleton(new SimpleGrantedAuthority("user")));

            }
        };
    }
}
>>>>>>> ce107c5f17ec84b730680de36e8a86860f152bf7
