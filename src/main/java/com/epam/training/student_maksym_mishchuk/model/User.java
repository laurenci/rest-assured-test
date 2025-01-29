package com.epam.training.student_maksym_mishchuk.model;

public record User (Long id, String name, String username, String email, Address address, String phone, String website, Company company) {
    private record Address (String street, String suite, String city, String zipcode, Geo geo) {
        private record Geo (Double lat, Double lng) {

        }
    }
    private record Company (String name, String catchPhrase, String bs) {

    }
}
