
package org.ModelDAOImpl;

import org.BD.Utils;
import org.Model.Professor;
import org.ModelDAO.ProfessorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProfessorDAOImpl implements ProfessorDAO {

    @Override
    public void addDam2(Professor professor) {
        String sql = "INSERT INTO Professors (nom, cognoms) VALUES (?, ?)";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, professor.getNom());
            ps.setString(2, professor.getCognom());

            ps.executeUpdate();

            System.out.println("Professor afegit correctament.");

        } catch (SQLException e) {
            System.out.println("Error en afegir el professor: " + e.getMessage());
        }
    }

}
