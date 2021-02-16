package ru.daniilazarnov.server.configuration;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ServerConfiguration {

    private String root;

    public ServerConfiguration() {
        InputStream is = null;
        Properties property = new Properties();
        try {
            var cls = getClass();
            is = getClass().getClassLoader().getResourceAsStream("config.properties");
            property.load(is);
            root = property.getProperty("root");
        } catch (IOException e) {
            System.err.println("Error has been occurred while reading client configuration!");
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public String getRoot() {
        return root;
    }
}
