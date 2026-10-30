
package org.ModelDAOImpl;

import org.BD.Utils;
import org.Model.ModulsProfessionals;
import org.ModelDAO.ModulsProfessionalsDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ModulsProfessionalsDAOImpl implements ModulsProfessionalsDAO {

    @Override
    public void addDam2(ModulsProfessionals modulsProfessionals) {
        String sql = "INSERT INTO MODULSPROFESSIONALS (NOM, ID_PROFESSOR) VALUES (?, ?)";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, modulsProfessionals.getNom());
            ps.setInt(2, modulsProfessionals.getId_professor());

            ps.executeUpdate();

            System.out.println("Modul profesional afegit correctament.");

        } catch (SQLException e) {
            System.out.println("Error en afegir el professor: " + e.getMessage());
        }
    }

    @Override
    public void readDam2(ModulsProfessionals modulsProfessionals) {
        String sql = "SELECT * FROM modulsprofessionals";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("Moduls professionals:");

            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("ID") +
                                " | Nom: " + rs.getString("NOM") +
                                " | ID Professor: " + rs.getInt("ID_PROFESSOR")
                );
            }

        } catch (SQLException e) {
            System.out.println("Error en llistar els moduls professionals: " + e.getMessage());
        }
    }

    @Override
    public void deleteDam2(ModulsProfessionals modulsProfessionals) {
        String sql = "DELETE FROM modulsprofessionals WHERE ID = ?";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, modulsProfessionals.getId());

            int filesEliminades = ps.executeUpdate();

            if (filesEliminades > 0) {
                System.out.println("Modul professional eliminat correctament.");
            } else {
                System.out.println("No s'ha trobat cap modul amb aquest ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error en eliminar el modul professional: " + e.getMessage());
        }
    }

    @Override
    public void updateDam2(ModulsProfessionals modulsProfessionals) {
        String sql = "UPDATE modulsprofessionals SET NOM = ?, ID_PROFESSOR = ? WHERE ID = ?";

        try (Connection con = Utils.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, modulsProfessionals.getNom());
            ps.setInt(2, modulsProfessionals.getId_professor());
            ps.setInt(3, modulsProfessionals.getId());

            int filesActualitzades = ps.executeUpdate();

            if (filesActualitzades > 0) {
                System.out.println("Modul professional actualitzat correctament.");
            } else {
                System.out.println("No s'ha trobat cap modul amb aquest ID.");
            }

        } catch (SQLException e) {
            System.out.println("Error en actualitzar el modul professional: " + e.getMessage());
        }
    }
}

