package entites;

public class Conseil {
    private int id ;
    private  String titre,contenu,categorie;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public String getContenu() {
        return contenu;
    }

    public void setContenu(String contenu) {
        this.contenu = contenu;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Conseil() {
    }

    public Conseil(int id,String titre,String contenu,String categorie) {
        this.id = id;
        this.titre=titre;
        this.contenu=contenu;
        this.categorie=categorie;
    }

    public Conseil(String titre,String contenu,String categorie) {
        this.titre=titre;
        this.contenu=contenu;
        this.categorie=categorie;
    }

    @Override
    public String toString() {
        return "Conseil{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", contenu='" + contenu + '\'' +
                ", categorie='" + categorie + '\'' +
                '}';
    }
}
