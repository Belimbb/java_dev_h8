package org.example.serviceClasses;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {
    private Properties properties;

    public PropertiesReader(String propertiesFilePath) {
        properties = new Properties();
        try (InputStream inputStream = new FileInputStream(propertiesFilePath)) {
            properties.load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getPostgresUrlConnection(){
        return new StringBuilder("jdbc:postgresql://")
                .append(properties.getProperty("postgres.db.host"))
                .append(":")
                .append(properties.getProperty("postgres.db.port"))
                .append("/")
                .append(properties.getProperty("postgres.db.database"))
                .append("?currentSchema=public")
                .toString();
    }
    public String getPostgresUsername() {
        return properties.getProperty("postgres.db.username");
    }

    public String getPostgresPassword() {
        return properties.getProperty("postgres.db.password");
    }
}


