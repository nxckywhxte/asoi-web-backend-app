package ru.nw.asoi.web.backend.app.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.SimpleDateFormat;
import java.util.UUID;

@Table(name = "user_profiles")
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class UserProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private UUID id;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "patronymic")
    private String patronymic;

    @Column(name = "avatar_url", nullable = true)
    private String avatar_path;

    @Column(name = "birthday", nullable = true)
    private SimpleDateFormat birthday;

    @OneToOne(mappedBy = "userProfile")
    private UserEntity user;



}
