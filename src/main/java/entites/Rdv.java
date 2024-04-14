package entites;

import java.time.LocalDate;
import java.time.LocalTime;

public class Rdv {
    private Long id;
    private LocalDate date;
    private LocalTime heure;
    private String choix;
    private String description;

    public Rdv() {
    }

    public Rdv(LocalDate date, LocalTime heure, String choix, String description) {
        this.date = date;
        this.heure = heure;
        this.choix = choix;
        this.description = description;

    }

    public Rdv(int i, String s, String s1, String date, String time) {
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getHeure() {
        return heure;
    }

    public void setHeure(LocalTime heure) {
        this.heure = heure;
    }

    public String getChoix() {
        return choix;
    }

    public void setChoix(String choix) {
        this.choix = choix;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Rdv{" +
                "id=" + id +
                ", date=" + date +
                ", heure=" + heure +
                ", choix='" + choix + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
