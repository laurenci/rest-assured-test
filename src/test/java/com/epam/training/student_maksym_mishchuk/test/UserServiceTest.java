package com.epam.training.student_maksym_mishchuk.test;

import com.epam.training.student_maksym_mishchuk.extension.UserServiceExtension;
import com.epam.training.student_maksym_mishchuk.model.User;
import com.epam.training.student_maksym_mishchuk.provider.UserProvider;
import com.epam.training.student_maksym_mishchuk.provider.UserWithIdProvider;
import com.epam.training.student_maksym_mishchuk.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(UserServiceExtension.class)
public class UserServiceTest {
    UserService userService;

    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void getUsersTest() {
        assertNotEquals(0, userService.get().length);
    }

    @ParameterizedTest
    @ValueSource(longs = {1})
    void getUserById(Long id) {
        assertNotNull(userService.getById(id));
    }

    @ParameterizedTest
    @ArgumentsSource(UserProvider.class)
    void postUserTest(User user) {
        assertNotNull(userService.post(user).id());
    }

    @ParameterizedTest
    @ArgumentsSource(UserWithIdProvider.class)
    void putUserTest(Long id, User user) {
        assertNotNull(userService.put(id, user));
    }

    @ParameterizedTest
    @ValueSource(longs = {1})
    void deleteUserTest(Long id) {
        assertNotNull(userService.deleteById(id));
    }
}