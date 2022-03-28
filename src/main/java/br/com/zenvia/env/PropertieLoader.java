package br.com.zenvia.env;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class PropertieLoader {

    public static PropertieLoader get() {
        return new PropertieLoader();
    }

    public String getAuthenticateURI(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> urlConfigurations = (Map<String, String>) root.get("url-config");
        return urlConfigurations.get("baseURI");
    }

    public String getEmail(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> userConfigurations = (Map<String, String>) root.get("user-config");
        return userConfigurations.get("email");
    }

    public String getPassword(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> userConfigurations = (Map<String, String>) root.get("user-config");
        return userConfigurations.get("password");
    }
}