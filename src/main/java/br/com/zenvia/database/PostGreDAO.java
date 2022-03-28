//package br.com.zenvia.database;
//
//import br.com.zenvia.env.EnvironmentActualLoader;
//import br.com.zenvia.env.PropertieLoaderDataBase;
//import org.apache.log4j.Logger;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class PostGreDAO {
//
//    private static final Logger logger = Logger.getLogger(PostGreDAO.class);
//
//    protected String USER = PropertieLoaderDataBase.get().getUser(EnvironmentActualLoader.get());
//    protected String PASSWORD = PropertieLoaderDataBase.get().getPassword(EnvironmentActualLoader.get());
//    protected String HOST = PropertieLoaderDataBase.get().getHost(EnvironmentActualLoader.get());
//
//    public void saveRecords(String testName, String status) throws ClassNotFoundException {
//        Connection connection;
//        Statement statement;
//        try {
//            connection = getConnection();
//            statement = connection.createStatement();
//            String sql = "insert into public.\"test_flow_service\"(dt_execucao, nome, resultado) values (current_timestamp, '" + testName + "', '" + status + "');";
//            statement.executeUpdate(sql);
//
//            statement.close();
//            connection.commit();
//            connection.close();
//        } catch (SQLException sqlException) {
//            logger.info(sqlException.getClass().getName() + ": " + sqlException.getMessage());
//        }
//        logger.info("Records created successfully");
//    }
//
//
//    private Connection getConnection() {
//        try {
//            Connection newConnection;
//            Class.forName("org.postgresql.Driver");
//            newConnection = DriverManager.getConnection(HOST, USER, PASSWORD);
//            logger.info("Opened database successfully");
//            newConnection.setAutoCommit(false);
//            return newConnection;
//        } finally {
//
//        }
//    }
//}
