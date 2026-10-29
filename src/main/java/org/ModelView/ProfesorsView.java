
package org.ModelView;

import org.Model.Professor;
import org.ModelController.ProfesorsController;

import java.util.Scanner;

public class ProfesorsView {

    private Scanner input = new Scanner(System.in);
    private ProfesorsController controller = new ProfesorsController();

    public void demanaProfessor() {
        System.out.println("Introdueix el nom del professor:");
        String nom = input.nextLine();

        System.out.println("Introdueix el cognom del professor:");
        String cognom = input.nextLine();

        Professor professor = new Professor(nom, cognom);

        controller.altaProfessor(professor);
    }
}
