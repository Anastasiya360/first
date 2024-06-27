package com.example.first.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(schema = "shop", name = "users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "surname")
    private String surname;

    @Column(name = "role_id")
    private Integer role_id;

    @Column(name = "birthday")
    private LocalDate birthday;

    @Column(name = "login")
    private String login;

    @Column(name = "password")
    private String password;

    @Column(name = "phone")
    private String phone;
}
