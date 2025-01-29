package com.epam.training.student_maksym_mishchuk.util;

import com.epam.training.student_maksym_mishchuk.exception.ResourceNotFoundException;

import java.net.URL;

public class ResourcePathProvider {
    public static String getResourcePath(String resourceName) {
        URL resource = ResourcePathProvider.class.getClassLoader().getResource(resourceName);
        if (resource == null) {
            throw new ResourceNotFoundException("Resource not found: " + resourceName);
        }
        return resource.getPath();
    }
}
