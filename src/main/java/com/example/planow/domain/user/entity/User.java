package com.example.planow.domain.user.entity;

import com.example.planow.domain.user.userrole.UserRole;
import com.example.planow.global.entity.Timestamped;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    private String nickname;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    @Builder.Default
    private UserRole userRole = UserRole.ROLE_USER;

    public void update(String nickname){
        this.nickname = nickname;
    }
}
