package com.BookXChange.Config;

import com.BookXChange.Model.UserModel;
import com.BookXChange.Services.UserServices;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.LogoutConfigurer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.boot.autoconfigure.security.servlet.PathRequest.toH2Console;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService(UserServices userServices){
        return username -> {
            UserModel user = userServices.getUserByUsername(username);
            if(user != null) return user;
            throw new UsernameNotFoundException("user" + username + "not Found");
        };
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity.authorizeHttpRequests(
                request -> request
                        .requestMatchers(toH2Console()).permitAll()
                        .requestMatchers("/","/auth/**","logout","/css/**","/images/**","/js/**").permitAll()
                        .anyRequest().authenticated()
        )
                .formLogin(
                        form -> form
                                .loginPage("/auth/login").defaultSuccessUrl("/",true)
                )

                .logout(LogoutConfigurer::permitAll)

                .headers(headers -> headers.frameOptions().disable())

                .csrf(csrf -> csrf.ignoringRequestMatchers(toH2Console()))

                .build();

    }


}
