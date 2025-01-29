package com.epam.training.student_maksym_mishchuk.context.property_reader.file;

import com.epam.training.student_maksym_mishchuk.context.property_reader.PropertiesReader;
import com.epam.training.student_maksym_mishchuk.exception.FilePropertiesException;

import java.io.*;
import java.util.Properties;

public class FilePropertiesReader implements PropertiesReader {
    private final Properties properties = new Properties();

    public FilePropertiesReader(String path) {
        if (path == null || path.isBlank()) {
            throw new FilePropertiesException("File path cannot be null or empty");
        }

        try (Reader reader = new BufferedReader(new FileReader (path))) {
            properties.load(reader);
        } catch (IOException e) {
            throw new FilePropertiesException(e.getMessage());
        }
    }

    @Override
    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
