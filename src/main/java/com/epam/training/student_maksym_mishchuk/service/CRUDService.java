package com.epam.training.student_maksym_mishchuk.service;

public interface CRUDService <T, ID>{
    T[] get();
    T getById(ID id);
    T post(T t);
    T put(ID id, T t);
    T deleteById(ID id);
}
