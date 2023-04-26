package ru.nw.asoi.web.backend.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nw.asoi.web.backend.app.entity.RoleEntity;
import ru.nw.asoi.web.backend.app.entity.TokenEntity;
import ru.nw.asoi.web.backend.app.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<UserEntity, UUID> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);


    @Query(value = """
      select u from UserEntity u
      """)
    List<UserEntity> findAllUsers();

    @Query(value = """
      select u from UserEntity u where u.email = :email
      """)
    UserEntity findOneUserByEmail(String email);

    @Query(value = """
      select u from UserEntity u where u.username = :username
      """)
    UserEntity findOneUserByUserName(String username);
}
