package ru.nw.asoi.web.backend.app.controller;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nw.asoi.web.backend.app.entity.RoleEntity;
import ru.nw.asoi.web.backend.app.service.role.RoleService;

import java.util.Collection;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/admin/roles")
public class RoleController {
    private final RoleService roleService;


    // Создание роли
    @PostMapping()
    ResponseEntity<RoleEntity> createRole(@RequestBody RoleEntity role) {
        RoleEntity newRole = roleService.createRole(role);
        return new ResponseEntity<>(newRole, HttpStatus.CREATED);
    }


    // Обновление роли
    @PatchMapping(value = "/{name}")
    ResponseEntity<RoleEntity> updateRole(@PathVariable String name, @RequestBody RoleEntity role) {
        RoleEntity updatedRole = roleService.updateRole(name, role);
        return new ResponseEntity<>(updatedRole,HttpStatus.OK);
    }


    // Удаление роли
    @DeleteMapping(value = "/{name}")
    ResponseEntity<String> deleteRole(@PathVariable String name) {
        roleService.deleteRole(name);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    //Получение всех ролей
    @GetMapping()
    ResponseEntity<List<RoleEntity>> getAllRoles() {
        List<RoleEntity> allRoles = roleService.getAllRoles();
        return new ResponseEntity<>(allRoles, HttpStatus.OK);
    }

}
