package com.epam.training.student_maksym_mishchuk.service;

import com.epam.training.student_maksym_mishchuk.context.Context;
import com.epam.training.student_maksym_mishchuk.model.User;


import static io.restassured.RestAssured.when;

public class UserService {
    private static final String endpoint = Context.propertiesReader.getProperty("endpoint.users");

    public User[] getUsers() {
        var response = when()
                .get(endpoint);

        response.then()
                .assertThat()
                .statusCode(200)
                .contentType("application/json; charset=utf-8");

        return response.as(User[].class);
    }
}
