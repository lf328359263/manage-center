package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;

@Data
@ToString(exclude = {"password"})
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class User {

    @NonNull
    @GeneratedValue
    @Id
    private Integer id;
    private String name;
    @Column(unique = true)
    private String username;
    private String password;
}
