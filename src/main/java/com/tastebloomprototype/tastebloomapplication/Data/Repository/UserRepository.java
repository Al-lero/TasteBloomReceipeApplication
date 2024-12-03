package com.tastebloomprototype.tastebloomapplication.Data.Repository;

import com.tastebloomprototype.tastebloomapplication.Data.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);
    Boolean existsUserByEmail(String email);

}
