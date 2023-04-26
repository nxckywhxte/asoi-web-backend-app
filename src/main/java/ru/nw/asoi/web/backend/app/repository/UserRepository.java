package ru.nw.asoi.web.backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nw.asoi.web.backend.app.entity.UserEntity;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByEmail(String username);

}
