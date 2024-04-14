package services;

import entites.Rdv;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceRdv {
    private Connection connection;

    public ServiceRdv() {
        this.connection = MyDatabase.getInstance().getConnection();
    }

    public void ajouter(Rdv rdv, Long userId) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not initialized.");
        }

        String insertQuery = "INSERT INTO rdv ( date, heure, choix, description) VALUES ( ?, ?, ?, ?, ?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery)) {
            if (rdv.getId() != null) {
                preparedStatement.setLong(1, rdv.getId());
            } else {
                preparedStatement.setNull(1, java.sql.Types.NULL);
            }

            preparedStatement.setDate(2, java.sql.Date.valueOf(rdv.getDate()));
            preparedStatement.setTime(3, java.sql.Time.valueOf(rdv.getHeure()));
            preparedStatement.setString(4, rdv.getChoix());
            preparedStatement.setString(5, rdv.getDescription());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) inserted.");
        }
    }

    public Rdv getById(Long id) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not initialized.");
        }

        String selectQuery = "SELECT * FROM rdv WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setLong(1, id);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    Rdv rdv = new Rdv();
                    rdv.setId(resultSet.getLong("id"));
                    rdv.setDate(resultSet.getDate("date").toLocalDate());
                    rdv.setHeure(resultSet.getTime("heure").toLocalTime());
                    rdv.setChoix(resultSet.getString("choix"));
                    rdv.setDescription(resultSet.getString("description"));
                    return rdv;
                }
            }
        }
        return null;
    }

    public List<Rdv> getAll() throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not initialized.");
        }

        List<Rdv> rdvList = new ArrayList<>();
        String selectQuery = "SELECT * FROM rdv";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(selectQuery)) {
            while (resultSet.next()) {
                Rdv rdv = new Rdv();
                rdv.setId(resultSet.getLong("id"));
                rdv.setDate(resultSet.getDate("date").toLocalDate());
                rdv.setHeure(resultSet.getTime("heure").toLocalTime());
                rdv.setChoix(resultSet.getString("choix"));
                rdv.setDescription(resultSet.getString("description"));
                rdvList.add(rdv);
            }
        }
        return rdvList;
    }

    public void update(Rdv rdv) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not initialized.");
        }

        String updateQuery = "UPDATE rdv SET date = ?, heure = ?, choix = ?, description = ? WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateQuery)) {
            preparedStatement.setDate(1, java.sql.Date.valueOf(rdv.getDate()));
            preparedStatement.setTime(2, java.sql.Time.valueOf(rdv.getHeure()));
            preparedStatement.setString(3, rdv.getChoix());
            preparedStatement.setString(4, rdv.getDescription());
            preparedStatement.setLong(5, rdv.getId());

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) updated.");
        }
    }

    public void supprimer(Long id) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not initialized.");
        }

        String deleteQuery = "DELETE FROM rdv WHERE id = ?";
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
            preparedStatement.setLong(1, id);

            int rowsAffected = preparedStatement.executeUpdate();
            System.out.println(rowsAffected + " row(s) deleted.");
        }
    }

    public void ajouter(Rdv rdv1) {
    }
}
