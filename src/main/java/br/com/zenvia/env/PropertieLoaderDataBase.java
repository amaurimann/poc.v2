package br.com.zenvia.env;

import org.yaml.snakeyaml.Yaml;

import java.util.Map;

public class PropertieLoaderDataBase {
    public static PropertieLoaderDataBase get() {
        return new PropertieLoaderDataBase();
    }

    public String getUser(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> dbConfigurations = (Map<String, String>) root.get("postgre-config");
        return dbConfigurations.get("user");
    }
    public String getPassword(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> dbConfigurations = (Map<String, String>) root.get("postgre-config");
        return dbConfigurations.get("password");
    }
    public String getDatabasename(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> dbConfigurations = (Map<String, String>) root.get("postgre-config");
        return dbConfigurations.get("databasename");
    }
    public String getHost(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> dbConfigurations = (Map<String, String>) root.get("postgre-config");
        return dbConfigurations.get("host");
    }
    public String getAuthSource(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> dbConfigurations = (Map<String, String>) root.get("postgre-config");
        return dbConfigurations.get("auth_source");
    }
//    public String getPort(Environment environment) {
//        Yaml yaml = new Yaml();
//        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
//        Map<String, String> dbConfigurations = (Map<String, String>) root.get("postgre-config");
//        return (dbConfigurations.get("port"));
//    }
    public String getSslSettings(Environment environment) {
        Yaml yaml = new Yaml();
        Map<String, Object> root = yaml.load(getClass().getClassLoader().getResourceAsStream(environment.getEnvironment()));
        Map<String, String> dbConfigurations = (Map<String, String>) root.get("postgre-config");
        return dbConfigurations.get("ssl_settings");
    }
}
