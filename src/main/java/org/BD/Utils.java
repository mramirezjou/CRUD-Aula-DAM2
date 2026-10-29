
package org.BD;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Utils {

    private static final Dotenv dotenv = Dotenv.configure()
            .ignoreIfMissing()
            .load();

    private static final String URL = dotenv.get("URLSQL");
    private static final String USER = dotenv.get("USERSQL");
    private static final String PASSWORD = dotenv.get("PASSWORDSQL");

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            System.err.println("Connexió fallida: " + e.getMessage());
            return null;
        }
    }
}
