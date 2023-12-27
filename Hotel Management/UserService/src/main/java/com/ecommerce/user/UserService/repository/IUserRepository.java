package com.ecommerce.user.UserService.repository;

import com.ecommerce.user.UserService.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, String> {
}
