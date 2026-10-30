
package org.ModelView;

import org.Model.Professor;
import org.ModelController.ProfesorsController;
import org.ModelDAOImpl.ProfessorDAOImpl;

import java.util.List;
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
    }public void eliminaProfessor(){
        System.out.println("Introdueix el nom del professor:");
        String nom = input.nextLine();

        System.out.println("Introdueix el cognom del professor:");
        String cognom = input.nextLine();

        Professor professor = new Professor(nom, cognom);
        controller.deleteDam2(professor);
        System.out.println("Eliminant professor.");
    }public void actualitzarProfessor(){
        System.out.println("Introdueix el nom del professor:");
        String nom = input.nextLine();

        System.out.println("Introdueix el cognom del professor:");
        String cognom = input.nextLine();

        Professor professor = new Professor(nom, cognom);
        controller.updateDam2(professor);
        System.out.println("Professor actualitzat!");
    }
    public void llegirProfessor(){
        List<Professor> professors = controller.readDam2();

        if (professors.isEmpty()) {
            System.out.println("No hi ha cap professor.");
        } else {
            for (Professor p : professors) {
                System.out.println(p.getId() + " - " + p.getNom() + " " + p.getCognom());
            }
        }
    }
}
