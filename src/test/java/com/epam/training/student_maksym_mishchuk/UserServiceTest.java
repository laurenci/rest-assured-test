package com.epam.training.student_maksym_mishchuk;

import com.epam.training.student_maksym_mishchuk.extension.UserServiceExtension;
import com.epam.training.student_maksym_mishchuk.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(UserServiceExtension.class)
public class UserServiceTest {
    UserService userService;

    public UserServiceTest(UserService userService) {
        this.userService = userService;
    }

    @Test
    void getUsersTest() {
        userService.getUsers();
        assertNotEquals(0, userService.getUsers().length);
    }
}