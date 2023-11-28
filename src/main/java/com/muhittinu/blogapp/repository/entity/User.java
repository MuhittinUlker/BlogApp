package com.muhittinu.blogapp.repository.entity;

import com.muhittinu.blogapp.customannotations.ValidPassword;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "tbl_users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String username;
    @Email
    @Column(unique = true)
    private String email;
    @ValidPassword
    private String password;
    private String photo;
    private Integer followingCount;
    private Integer followerCount;
    @OneToMany
    private List<User> followers;
    @OneToMany
    private List<User> following;
    @OneToMany
    private List<Post> favPosts;
    @OneToMany
    private List<Category> favCategories;
    @Builder.Default
    private Long registrationDate = System.currentTimeMillis();
}
