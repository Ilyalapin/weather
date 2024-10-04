package com.example.weather.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users", indexes = {@Index(name = "idx_login", columnList = "login")})
public class User {


    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String login;

    @Column(nullable = false)
    private String password;

}
