package tests;

import entites.Defi;
import entites.Rdv;
import services.ServiceDefi;
import services.ServiceRdv;

import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;

public class Main {
    public static <Rdv> void main(String[] args) {
        Defi def1 = new Defi(7, "1ere defi", "defi ", "un mois", "mars", "fev");
        ServiceDefi serviceDefi = new ServiceDefi();

        try {
            serviceDefi.afficher();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        try {
            serviceDefi.supprimer(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        // Création d'un objet Rdv avec LocalDate et LocalTime
        // Creating LocalDate and LocalTime objects
        LocalDate dateRdv = LocalDate.of(2024, 4, 14);
        LocalTime heureRdv = LocalTime.of(14, 0); // 14:00
        Long userId = 123L; // Replace 123L with the actual user ID

        // Creating Rdv object using the constructor with LocalDate and LocalTime
        LocalDate dateRdv = LocalDate.of(2024, 4, 14);
        LocalTime heureRdv = LocalTime.of(14, 0); // 14:00

        // Creating Rdv object
        Rdv rdv1;
        rdv1 = new Rdv(dateRdv, heureRdv, "Choix du rendez-vous", "Description du rendez-vous");

        ServiceRdv serviceRdv = new ServiceRdv();
        try {
            serviceRdv.ajouter(rdv1);
            System.out.println("Rendez-vous ajouté avec succès !");
        } catch (SQLException e) {
            System.out.println("Erreur lors de l'ajout du rendez-vous : " + e.getMessage());
        }
    }
}}