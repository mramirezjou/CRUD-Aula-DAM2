
package org;

import io.github.cdimascio.dotenv.Dotenv;
import org.BD.Utils;
import org.ModelView.ModulsProfessionalsView;
import org.ModelView.ProfesorsView;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class Main {

    public static boolean existeixTaula(Connection connexio, String taula) throws SQLException {
        DatabaseMetaData meta = connexio.getMetaData();

        try (ResultSet rs = meta.getTables(null, null, taula.toUpperCase(), null)) {
            return rs.next();
        }
    }


    public static void executarCrud(Connection connexio) throws Exception {
        Dotenv dotenv = Dotenv.load();
        String dbType = dotenv.get("DB_TYPE");
        String script="";
        if(dbType.equals("oracle")){
            script = Files.readString(
                    Path.of("src/main/java/org/BD/crud.sql")
            );
        }else {
            script = Files.readString(
                    Path.of("src/main/java/org/BD/crudMysql.sql")
            );
        }


        for (String sql : script.split(";")) {
            sql = sql.trim();

            if (!sql.isEmpty()) {
                try (Statement st = connexio.createStatement()) {
                    st.execute(sql);
                } catch (SQLException e) {
                    System.out.println("Error en aquesta sentència:");
                    System.out.println(sql);
                    throw e;
                }
            }
        }

        System.out.println("Taules creades correctament.");
    }


    public static void main(String[] args) {

        try (Connection connexio = Utils.getConnection()) {
            if (connexio != null && !connexio.isClosed()) {
                System.out.println("Connexió establerta amb èxit a la BD DAM2!");

                if (!existeixTaula(connexio, "PROFESSORS")) {
                    executarCrud(connexio);
                } else {
                    System.out.println("Les taules ja existeixen.");
                }
            }
        } catch (Exception e) {
            System.err.println("Error en preparar la BD: " + e.getMessage());
        }

        Scanner input = new Scanner(System.in);
        int opcio1;
        int opcio2;
        boolean sortir = false;

        ProfesorsView vistaProfessors = new ProfesorsView();
        ModulsProfessionalsView vistaModulsProfessionals = new ModulsProfessionalsView();

        while (!sortir) {
            System.out.println("\n--- MENU PRINCIPAL ---");
            System.out.println("1. Gestionar professors");
            System.out.println("2. Gestionar moduls professionals");
            System.out.println("3. Sortir");
            System.out.print("Escull una opcio: ");

            opcio1 = input.nextInt();

            switch (opcio1) {
                case 1:
                    do {
                        System.out.println("\n--- GESTIONAR PROFESSORS ---");
                        System.out.println("1. Alta");
                        System.out.println("2. Llistar");
                        System.out.println("3. Actualitzar");
                        System.out.println("4. Eliminar");
                        System.out.println("5. Tornar al menu");
                        System.out.print("Escull una opcio: ");

                        opcio2 = input.nextInt();

                        switch (opcio2) {
                            case 1:
                                vistaProfessors.demanaProfessor();
                                break;
                            case 2:
                                System.out.println("Llistar professors");
                                break;
                            case 3:
                                System.out.println("Actualitzar professors");
                                break;
                            case 4:
                                System.out.println("Eliminar professors");
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opcio incorrecta");
                        }
                    } while (opcio2 != 5);
                    break;

                case 2:
                    do {
                        System.out.println("\n--- GESTIONAR MODULS PROFESSIONALS ---");
                        System.out.println("1. Alta");
                        System.out.println("2. Llistar");
                        System.out.println("3. Actualitzar");
                        System.out.println("4. Eliminar");
                        System.out.println("5. Tornar al menu");
                        System.out.print("Escull una opcio: ");

                        opcio2 = input.nextInt();

                        switch (opcio2) {
                            case 1:
                                vistaModulsProfessionals.demanaModulsProfessionals();
                                break;
                            case 2:
                                vistaModulsProfessionals.consultarModulsProfessionals();
                                break;
                            case 3:
                                vistaModulsProfessionals.actualitzarModulsProfessionals();
                                break;
                            case 4:
                                vistaModulsProfessionals.eliminarModulsProfessionals();
                                break;
                            case 5:
                                break;
                            default:
                                System.out.println("Opcio incorrecta");
                        }
                    } while (opcio2 != 5);
                    break;

                case 3:
                    sortir = true;
                    System.out.println("Sortint del programa...");
                    break;

                default:
                    System.out.println("Opcio incorrecta");
            }
        }

        input.close();
    }
}
