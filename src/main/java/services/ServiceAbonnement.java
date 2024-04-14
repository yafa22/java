package services;

import entites.Abonnement;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceAbonnement implements IService<Abonnement> {
    Connection connection;

    public ServiceAbonnement() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Abonnement abonnement) throws SQLException {
        String req = "INSERT INTO abonnement (date_debut, date_fin, salle_id ) VALUES (?, ?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setDate(1, Date.valueOf(abonnement.getDateDebut()));
        preparedStatement.setDate(2, Date.valueOf(abonnement.getDateFin()));
        preparedStatement.setLong(3, abonnement.getSalle().getId());


        preparedStatement.executeUpdate();
        System.out.println("Abonnement ajouté.");
    }

    @Override
    public void modifier(Abonnement abonnement) throws SQLException {
        String req = "UPDATE abonnement SET date_debut=?, date_fin=?, salle_id=?, user_id=? WHERE id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setDate(1, Date.valueOf(abonnement.getDateDebut()));
        preparedStatement.setDate(2, Date.valueOf(abonnement.getDateFin()));
        preparedStatement.setLong(3, abonnement.getSalle().getId());

        preparedStatement.setLong(5, abonnement.getId());

        preparedStatement.executeUpdate();
        System.out.println("Abonnement modifié.");
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM abonnement WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Abonnement supprimé.");
    }

    @Override
    public List<Abonnement> afficher() throws SQLException {
        List<Abonnement> abonnements = new ArrayList<>();
        String req = "SELECT * FROM abonnement";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(req);
        while (rs.next()) {
            Abonnement abonnement = new Abonnement();
            abonnement.setId(rs.getLong("id"));
            abonnement.setDateDebut(rs.getDate("date_debut").toLocalDate());
            abonnement.setDateFin(rs.getDate("date_fin").toLocalDate());
            // Assuming there are methods to fetch Salle and User by ID
            // abonnement.setSalle(fetchSalleById(rs.getLong("salle_id")));
            // abonnement.setUser(fetchUserById(rs.getLong("user_id")));
            // You need to implement the logic to fetch Salle and User by ID
            abonnements.add(abonnement);
        }
        return abonnements;
    }
}
