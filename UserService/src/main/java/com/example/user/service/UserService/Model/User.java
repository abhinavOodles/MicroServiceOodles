package com.example.user.service.UserService.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name="user_micro")
public class User {

    @Id
    //@GeneratedValue(strategy = GenerationType.SEQUENCE)
    private String userID ;
    private String name ;
    private int age ;
    private int number ;

    @Transient
    private List<Rating> ratings = new ArrayList<>();

}
