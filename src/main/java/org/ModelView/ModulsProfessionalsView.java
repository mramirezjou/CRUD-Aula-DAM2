
package org.ModelView;

import org.Model.ModulsProfessionals;
import org.ModelController.ModulsProfessionalsController;

import java.util.Scanner;

public class ModulsProfessionalsView {

    private Scanner input = new Scanner(System.in);
    private ModulsProfessionalsController controller = new ModulsProfessionalsController();

    public void demanaModulsProfessionals() {
        System.out.println("Introdueix el nom del modul:");
        String nom = input.nextLine();

        System.out.println("Introdueix el id del professor:");
        int id = input.nextInt();

        ModulsProfessionals modulsProfessionals = new ModulsProfessionals(nom, id);

        controller.altaModul(modulsProfessionals);
    }
    public void eliminarModulsProfessionals() {
        System.out.println("Introdueix el id del modul:");
        int id = input.nextInt();

        ModulsProfessionals modulsProfessionals = new ModulsProfessionals(id);

        controller.baixaModul(modulsProfessionals);
    }
    public void consultarModulsProfessionals() {
        ModulsProfessionals modulsProfessionals = new ModulsProfessionals();

        controller.llegirModul(modulsProfessionals);
    }
    public void actualitzarModulsProfessionals() {
        System.out.println("Introdueix el id del modul que vols actualitzar:");
        int idModul = input.nextInt();
        input.nextLine();

        System.out.println("Introdueix el nom del modul:");
        String nom = input.nextLine();

        System.out.println("Introdueix el id del professor:");
        int idProfessor = input.nextInt();

        ModulsProfessionals modulsProfessionals = new ModulsProfessionals(idModul, nom, idProfessor);

        controller.actualitzaModul(modulsProfessionals);
    }
}
