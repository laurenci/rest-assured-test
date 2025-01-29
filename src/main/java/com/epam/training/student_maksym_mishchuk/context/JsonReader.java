package com.epam.training.student_maksym_mishchuk.context;

import com.google.gson.Gson;
import com.google.gson.JsonIOException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class JsonReader {
    public synchronized  <T> T readFile(String path, Class<T> clazz) {
        try (Reader reader = new BufferedReader(new FileReader(path))) {
            return new Gson().fromJson(reader, clazz);
        } catch (IOException e) {
            throw new JsonIOException(e);
        }
    }
}