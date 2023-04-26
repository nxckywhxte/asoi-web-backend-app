package ru.nw.asoi.web.backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nw.asoi.web.backend.app.entity.RoleEntity;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {
}
