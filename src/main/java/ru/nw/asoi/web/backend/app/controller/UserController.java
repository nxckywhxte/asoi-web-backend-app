package ru.nw.asoi.web.backend.app.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.nw.asoi.web.backend.app.entity.RoleEntity;
import ru.nw.asoi.web.backend.app.entity.UserEntity;
import ru.nw.asoi.web.backend.app.entity.UserProfile;
import ru.nw.asoi.web.backend.app.service.user.UserService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
private final UserService userService;
    // Получение всех пользователей
    @GetMapping()
    ResponseEntity<List<UserEntity>> getAllRoles() {
        List<UserEntity> allUsers = userService.getAllUsers();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    // Обновление профиля пользователя

    @PatchMapping(value = "/{username}")
    ResponseEntity<UserEntity> updateUserProfile(@PathVariable String username, @RequestBody UserProfile userProfile) {
        UserEntity updatedProfile = userService.updateProfile(username, userProfile);
        return new ResponseEntity<>(updatedProfile, HttpStatus.OK);
    }


}
