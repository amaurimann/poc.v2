package br.com.zenvia.env;

public enum Environment {
    DEV("config-dev.yml"),

    TST("config-tst.yml"),

    STAGING("config-staging.yml");

    private String environment;

    Environment(String environment) {
        this.environment = environment;
    }

    public String getEnvironment() {
        return environment;
    }
}