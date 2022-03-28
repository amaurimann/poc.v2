package br.com.zenvia.database.frame;

public interface ConnectionPostGre {

    String getUserName();
    String getPassword();
    String getHostName();
//    int getPort();
    String getDataBase();
    boolean getSSLSettings();
}