package br.com.zenvia.database;

import br.com.zenvia.database.frame.ConnectionPostGre;
import br.com.zenvia.env.EnvironmentActualLoader;
import br.com.zenvia.env.PropertieLoaderDataBase;

public class PostGreConnection implements ConnectionPostGre {

    private static String USER =            PropertieLoaderDataBase.get().getUser(EnvironmentActualLoader.get());
    private static String DATABASENAME =    PropertieLoaderDataBase.get().getDatabasename(EnvironmentActualLoader.get());
    private static String PASS =            PropertieLoaderDataBase.get().getPassword(EnvironmentActualLoader.get());
    private static String HOST =            PropertieLoaderDataBase.get().getHost(EnvironmentActualLoader.get());
    private static String AUTH_SOURCE =     PropertieLoaderDataBase.get().getAuthSource(EnvironmentActualLoader.get());
//    private static String PORT =            PropertieLoaderDataBase.get().getPort(EnvironmentActualLoader.get());
    private static int PORT = 5432;
    private static boolean SSL_SETTINGS = false;


    @Override
    public String getHostName() {
        return HOST;
    }

//    @Override
//    public int getPort() {
//        return PORT;
//    }

    @Override
    public String getUserName() {
        return USER;
    }

    @Override
    public String getPassword() {
        return PASS;
    }

    @Override
    public String getDataBase() {
        return DATABASENAME;
    }

    @Override
    public boolean getSSLSettings() {
        return SSL_SETTINGS;
    }
}