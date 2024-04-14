package services;

import entites.Salle;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceSalle implements IService<Salle> {
    Connection connection;

    public ServiceSalle() {
        connection = MyDatabase.getInstance().getConnection();
    }

    @Override
    public void ajouter(Salle salle) throws SQLException {
        String req = "INSERT INTO salle (nom, image, prix) VALUES (?, ?, ?)";

        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setString(1, salle.getNom());
        preparedStatement.setString(2, salle.getImage());
        preparedStatement.setInt(3, salle.getPrix());

        preparedStatement.executeUpdate();
        System.out.println("Salle ajoutée.");
    }

    @Override
    public void modifier(Salle salle) throws SQLException {
        String req = "UPDATE salle SET nom=?, image=?, prix=? WHERE id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setString(1, salle.getNom());
        preparedStatement.setString(2, salle.getImage());
        preparedStatement.setInt(3, salle.getPrix());
        preparedStatement.setLong(4, salle.getId());

        preparedStatement.executeUpdate();
        System.out.println("Salle modifiée.");
    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req = "DELETE FROM salle WHERE id=?";
        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        System.out.println("Salle supprimée.");
    }

    @Override
    public List<Salle> afficher() throws SQLException {
        List<Salle> salles = new ArrayList<>();
        String req = "SELECT * FROM salle";
        Statement statement = connection.createStatement();
        ResultSet rs = statement.executeQuery(req);
        while (rs.next()) {
            Salle salle = new Salle();
            salle.setId(rs.getLong("id"));
            salle.setNom(rs.getString("nom"));
            salle.setImage(rs.getString("image"));
            salle.setPrix(rs.getInt("prix"));

            salles.add(salle);
        }
        return salles;
    }
}
