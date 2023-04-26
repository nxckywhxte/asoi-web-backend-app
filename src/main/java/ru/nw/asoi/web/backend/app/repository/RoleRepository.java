package ru.nw.asoi.web.backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import ru.nw.asoi.web.backend.app.entity.RoleEntity;
import ru.nw.asoi.web.backend.app.entity.UserEntity;

import java.util.List;
import java.util.UUID;

public interface RoleRepository extends JpaRepository<RoleEntity, UUID> {

    @Query(value = """
      select r from RoleEntity r where r.name = :name
      """)
    List<RoleEntity> findAllRolesByName(String name);

    @Query(value = """
      select r from RoleEntity r
      """)
    List<RoleEntity> findAllRoles();
}
