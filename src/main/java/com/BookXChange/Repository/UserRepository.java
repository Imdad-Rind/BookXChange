package com.BookXChange.Repository;

import com.BookXChange.Model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserModel , Long> {
    UserModel findByUsername(String Username);
}
