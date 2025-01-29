package com.epam.training.student_maksym_mishchuk.provider;

import com.epam.training.student_maksym_mishchuk.model.User;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.provider.Arguments;

import java.util.Arrays;
import java.util.stream.Stream;

public class UserWithIdProvider extends UserProvider{
    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext context) throws Exception {
       return super.provideArguments(context)
               .flatMap(arg -> Arrays.stream(arg.get()))
               .map(obj -> (User) obj)
               .map(user -> Arguments.of(user.id(), user));
    }
}
