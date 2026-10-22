public class Modul{
    private int id;
    private String nom;

    public Modul(String nom, int id) {
        this.nom = nom;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}