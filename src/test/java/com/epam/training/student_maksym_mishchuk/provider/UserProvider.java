package com.epam.training.student_maksym_mishchuk.provider;

import com.epam.training.student_maksym_mishchuk.context.Context;
import com.epam.training.student_maksym_mishchuk.model.User;
import com.epam.training.student_maksym_mishchuk.util.ResourcePathProvider;

import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class UserProvider implements ArgumentsProvider {
    private static final Map<String, User> loadedUsers = new HashMap<>();
    private static final String newUser = Context.propertiesReader.getProperty("users.json.new");
    private static final String existingUser = Context.propertiesReader.getProperty("users.json.existed");
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
        User user;
        String testType = getTestTypeByMethodName(context.getRequiredTestMethod().getName());
        if (loadedUsers.containsKey(testType)) {
            user = loadedUsers.get(testType);
        } else {
            user = Context.jsonReader.readFile(ResourcePathProvider.getResourcePath(testType), User.class);
            loadedUsers.put(testType, user);
        }

        return Stream.of(
                Arguments.of(user)
        );
    }

    private String getTestTypeByMethodName (String methodName) {
        if (methodName.contains("post")) {
            return newUser;
        }
        return existingUser;
    }
}
