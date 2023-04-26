package ru.nw.asoi.web.backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nw.asoi.web.backend.app.entity.UserProfile;

import java.util.UUID;

public interface UserProfileRepository extends JpaRepository<UserProfile, UUID> {
}
