package entites;

import java.util.ArrayList;
import java.util.Collection;

public class Salle {
    public Long id;
    public String nom;
    public String image;
    public Integer prix;
    public Collection<Abonnement> abonnements;

    // Constructors

    public Salle() {
        this.abonnements = new ArrayList<>();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getPrix() {
        return prix;
    }

    public void setPrix(Integer prix) {
        this.prix = prix;
    }

    public Collection<Abonnement> getAbonnements() {
        return abonnements;
    }

    public void setAbonnements(Collection<Abonnement> abonnements) {
        this.abonnements = abonnements;
    }

    public void addAbonnement(Abonnement abonnement) {
        if (abonnements == null) {
            abonnements = new ArrayList<>();
        }
        abonnements.add(abonnement);
    }

    public void removeAbonnement(Abonnement abonnement) {
        if (abonnements != null) {
            abonnements.remove(abonnement);
        }
    }

    // Override toString method
    @Override
    public String toString() {
        return "Salle{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", image='" + image + '\'' +
                ", prix=" + prix +
                '}';
    }
}
