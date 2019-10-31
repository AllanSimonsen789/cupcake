package datasource;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 *
 * @author Malthe
 */
public class DB {

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        try {

            InputStream prob = DB.class.getResourceAsStream("/livedb.properties");
            Properties pros = new Properties();
            pros.load(prob);

            // assign db parameters
            String url = pros.getProperty("url");
            String user = pros.getProperty("user");
            String password = pros.getProperty("password");

            // create a connection to the database
            if (conn == null) {

                Class.forName(DRIVER); //necessary because of servlet
                conn = DriverManager.getConnection(url, user, password);
            }
        } catch (ClassNotFoundException | SQLException | IOException ex) {
            System.out.println("DBCONNECTOR:" + ex.getMessage());

        }
        return conn;

    }
}
