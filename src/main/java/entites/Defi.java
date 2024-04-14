package entites;

public class Defi {
    private int id;
    private String titre,description,duree,date_debut,date_fin;

    public String getDescription() {
        return description;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDate_debut() {
        return date_debut;
    }

    public void setDate_debut(String date_debut) {
        this.date_debut = date_debut;
    }

    public String getDate_fin() {
        return date_fin;
    }

    public void setDate_fin(String date_fin) {
        this.date_fin = date_fin;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Defi() {
    }
    public Defi(int id,String titre , String description,String duree,String date_debut,String date_fin) {
        this.id=id;
        this.titre=titre;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }
    public Defi(String titre,String description,String duree,String date_debut,String date_fin) {
        this.titre=titre;
        this.description = description;
        this.duree = duree;
        this.date_debut = date_debut;
        this.date_fin = date_fin;
    }

    @Override
    public String toString() {
        return "Defi{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", duree='" + duree + '\'' +
                ", date_debut='" + date_debut + '\'' +
                ", date_fin='" + date_fin + '\'' +
                '}';
    }
}
