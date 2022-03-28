package br.com.zenvia.env;

import static br.com.zenvia.env.Environment.*;
import static java.lang.String.format;

public class EnvironmentActualLoader {

    private EnvironmentActualLoader() {
    }

    public static Environment get() {
        String env = System.getProperty("env", "tst");
        switch (env) {
            case "dev":
                return DEV;
            case "tst":
                return TST;
            case "staging":
                return STAGING;

            default:
                throw new IllegalArgumentException(format("Unconfigured %s environment for running tests", env));
        }
    }
}