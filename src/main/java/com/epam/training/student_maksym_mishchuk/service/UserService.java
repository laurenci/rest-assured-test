package com.epam.training.student_maksym_mishchuk.service;

import com.epam.training.student_maksym_mishchuk.context.Context;
import com.epam.training.student_maksym_mishchuk.model.User;
import io.restassured.response.Response;


import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserService implements CRUDService<User, Long>{
    private static final String endpoint = Context.propertiesReader.getProperty("users.endpoint");
    private static final String endpointWithId = endpoint.concat("/{id}");

    @Override
    public User[] get() {
        var response = when()
                .get(endpoint);
        checkResponse(response, 200);
        return response.as(User[].class);
    }

    @Override
    public User getById(Long id) {
        var response = given()
                .pathParam("id", id)
                .when()
                .get(endpointWithId);
        checkResponse(response, 200);
        return response.as(User.class);
    }

    @Override
    public User post(User user) {
        var response = given()
                .contentType("application/json")
                .body(user)
                .when()
                .post(endpoint);
        checkResponse(response, 201);
        return response.as(User.class);
    }

    @Override
    public User put(Long id, User user) {
        var response = given()
                .pathParam("id", id)
                .contentType("application/json")
                .body(user)
                .when()
                .put(endpointWithId);
        checkResponse(response, 200);
        return response.as(User.class);
    }

    @Override
    public User deleteById(Long id) {
        var response = given()
                .pathParam("id", id)
                .when()
                .delete(endpointWithId);
        checkResponse(response, 200);
        return response.as(User.class);
    }

    private void checkResponse(Response response, int statusCode) {
        response.then()
                .assertThat()
                .statusCode(statusCode)
                .contentType("application/json; charset=utf-8");
    }
}
