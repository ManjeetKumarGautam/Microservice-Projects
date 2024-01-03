package com.ecommerce.user.UserService.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {

    @Id
    private String userId;
    private String name;
    private String email;

    private String password;

    @Transient
    private List<Rating> ratings = new ArrayList<>();
}
