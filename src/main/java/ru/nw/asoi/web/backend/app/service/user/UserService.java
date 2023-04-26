package ru.nw.asoi.web.backend.app.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.nw.asoi.web.backend.app.entity.UserEntity;
import ru.nw.asoi.web.backend.app.entity.UserProfile;
import ru.nw.asoi.web.backend.app.repository.UserRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;


    public List<UserEntity> getAllUsers() {
        return userRepository.findAllUsers();
    }

    // TODO функция обновления профиля
    public UserEntity updateProfile(String username, UserProfile userProfile) {
        UserEntity existsUser = userRepository.findOneUserByUserName(username);
        if (existsUser != null) {
            if (existsUser.getUserProfile() == null) {
                existsUser.getUserProfile().setFirstName(userProfile.getFirstName());
                existsUser.getUserProfile().setLastName(userProfile.getLastName());
                existsUser.getUserProfile().setPatronymic(userProfile.getPatronymic());
                return userRepository.saveAndFlush(existsUser);
            }
            return null;
        }
        return null;
    }
}
