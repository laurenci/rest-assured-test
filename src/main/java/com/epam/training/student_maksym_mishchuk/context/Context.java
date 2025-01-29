package com.epam.training.student_maksym_mishchuk.context;

import com.epam.training.student_maksym_mishchuk.context.property_reader.file.FilePropertiesReader;
import static com.epam.training.student_maksym_mishchuk.util.ResourcePathProvider.getResourcePath;

public class Context {
    public static final FilePropertiesReader propertiesReader = new FilePropertiesReader(
            getResourcePath(System.getProperty("propertiesPath"))
    );

    public static final JsonReader jsonReader = new JsonReader();
}
