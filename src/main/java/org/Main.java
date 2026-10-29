package main.java.org;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

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
                    System.out.println("\n--- GESTIONAR PROFESSORS ---");

                    do {
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
                                System.out.println("Tornant al menu principal...");
                                break;
                            default:
                                System.out.println("Opcio incorrecta");
                        }

                    } while (opcio2 != 5);

                    break;

                case 2:
                    System.out.println("\n--- GESTIONAR MODULS PROFESSIONALS ---");

                    do {
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
                                System.out.println("Tornant al menu principal...");
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
