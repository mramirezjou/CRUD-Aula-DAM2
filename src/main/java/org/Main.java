import org.BD.Utils;

import java.sql.Connection;
import java.sql.SQLException;

public static void main(String[] args) {

    try (Connection connexio = Utils.getConnection()) {

        if (connexio != null && !connexio.isClosed()) {
            System.out.println("Connexió establerta amb èxit a la BD DAM2!");
        }

    } catch (SQLException e) {
        System.err.println("Error en tancar o gestionar la connexió: " + e.getMessage());
    }
}