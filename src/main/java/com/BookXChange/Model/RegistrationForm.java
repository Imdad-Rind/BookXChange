package com.BookXChange.Model;
import lombok.*;
import org.springframework.security.crypto.password.PasswordEncoder;

@Getter
@Setter
public class RegistrationForm {

    String fullname;
    String username;
    String email;
    String password;

    public UserModel toUser(PasswordEncoder encoder){
        return new UserModel(
                fullname,
                username,
                email,
                encoder.encode(password)
                );
    }

}
