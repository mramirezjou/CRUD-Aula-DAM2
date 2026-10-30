
package org.Model;

public class ModulsProfessionals {
    private int id;
    private String nom;
    private int id_professor;

    public ModulsProfessionals(int id , String nom, int id_professor) {
        this.id = id;
        this.nom = nom;
        this.id_professor = id_professor;
    }

    public ModulsProfessionals(String nom, int id_professor) {
        this.nom = nom;
        this.id_professor = id_professor;
    }
    public ModulsProfessionals(int id) {
        this.id = id;
    }

    public ModulsProfessionals() {}

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_professor() {
        return id_professor;
    }

    public void setId_professor(int id_professor) {
        this.id_professor = id_professor;
    }
    public int getId() {
        return id;
    }

}
