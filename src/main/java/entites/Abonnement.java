package entites;

import java.time.LocalDate;

public class Abonnement {
    private Long id;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private Salle salle;
    private User user;

    // Constructors
    public Abonnement() {
        this.dateDebut = LocalDate.now();
        this.dateFin = LocalDate.now();
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(LocalDate dateDebut) {
        this.dateDebut = dateDebut;
    }

    public LocalDate getDateFin() {
        return dateFin;
    }

    public void setDateFin(LocalDate dateFin) {
        this.dateFin = dateFin;
    }

    public Salle getSalle() {
        return salle;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    // Override toString method
    @Override
    public String toString() {
        return "Abonnement{" +
                "id=" + id +
                ", dateDebut=" + dateDebut +
                ", dateFin=" + dateFin +
                ", salle=" + salle +
                ", user=" + user +
                '}';
    }
}
