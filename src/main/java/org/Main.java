package org;

import org.BD.Utils;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        try (Connection connexio = Utils.getConnection()) {
            if (connexio != null && !connexio.isClosed()) {
                System.out.println("Connexió establerta amb èxit a la BD DAM2!");
            }
        } catch (SQLException e) {
            System.err.println("Error en connectar amb la BD: " + e.getMessage());
        }

        Scanner input = new Scanner(System.in);

        int opcio1;
        int opcio2;
        boolean sortir = false;

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
                                System.out.println("Alta de professors");
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
                                System.out.println("Alta de moduls professionals");
                                break;
                            case 2:
                                System.out.println("Llistar moduls professionals");
                                break;
                            case 3:
                                System.out.println("Actualitzar moduls professionals");
                                break;
                            case 4:
                                System.out.println("Eliminar moduls professionals");
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