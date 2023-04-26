package ru.nw.asoi.web.backend.app.service.role;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.nw.asoi.web.backend.app.entity.RoleEntity;
import ru.nw.asoi.web.backend.app.repository.RoleRepository;
import org.springframework.http.HttpStatus;

import javax.management.relation.Role;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class RoleService {
    private final RoleRepository roleRepository;

    public RoleEntity createRole(RoleEntity role) {
        var roles = roleRepository.findAllRolesByName(role.getName());
        if (roles.contains(role)) {
            new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        var newRole = RoleEntity.builder()
                .name(role.getName())
                .build();

        roleRepository.saveAndFlush(newRole);
        return newRole;
    }

    public RoleEntity updateRole(String name, RoleEntity role) {
        var roles = roleRepository.findAllRolesByName(name);
        if (!Objects.equals(roles.get(0).getName(), name)) {
            new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        roles.get(0).setName(role.getName());

        return roleRepository.saveAndFlush(roles.get(0));
    }

    public void deleteRole(String name) {
        var roles = roleRepository.findAllRolesByName(name);
        if (!Objects.equals(roles.get(0).getName(), name)) {
            new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        roleRepository.delete(roles.get(0));
    }

    public List<RoleEntity> getAllRoles() {
        return roleRepository.findAllRoles();
    }
}
