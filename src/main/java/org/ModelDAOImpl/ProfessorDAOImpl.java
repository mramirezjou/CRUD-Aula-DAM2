
package org.ModelDAOImpl;

import org.BD.Utils;
import org.Model.Professor;
import org.ModelDAO.ProfessorDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
    public void deleteDam2(Professor professor){
        String sql = "DELETE FROM Professors WHERE nom = ? AND cognoms = ?";
        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, professor.getNom());
            ps.setString(2, professor.getCognom());

            ps.executeUpdate();

            System.out.println("Professor eliminat correctament.");

        } catch (SQLException e) {
            System.out.println("Error en eliminar el professor: " + e.getMessage());
        }
    }
    public void updateDam2(Professor professor){
        String sql = "UPDATE Professors SET nom = ?, cognoms = ? WHERE id_profesor = ?";
        try (Connection con = Utils.getConnection()) {
            assert con != null;
            try (PreparedStatement ps = con.prepareStatement(sql)) {

                ps.setString(1, professor.getNom());
                ps.setString(2, professor.getCognom());

                int files = ps.executeUpdate();

                if (files > 0) {
                    System.out.println("Professor actualitzat correctament.");
                } else {
                    System.out.println("No s'ha trobat cap professor amb aquest id.");
                }

            }
        } catch (SQLException e) {
            System.out.println("Error en actualitzar el professor: " + e.getMessage());
        }
    }
    public List<Professor> readDam2(){
        List<Professor> professors = new ArrayList<>();
        String sql = "SELECT id_profesor, nom, cognoms FROM Professors";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                professors.add(new Professor(
                        rs.getInt("id_profesor"),
                        rs.getString("nom"),
                        rs.getString("cognoms")
                ));
            }

        } catch (SQLException e) {
            System.out.println("Error en llistar els professors: " + e.getMessage());
        }

        return professors;
    }


}
