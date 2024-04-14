package services;

import utils.MyDatabase;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ServiceDefi {
    private Connection connection;

    public ServiceDefi() {
        this.connection = MyDatabase.getInstance().getConnection();
    }

    public void afficher() throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not initialized.");
        }
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM defi")) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("ID: " + id + ", Name: " + name);
            }
        }
    }

    public void supprimer(int id) throws SQLException {
        if (connection == null) {
            throw new SQLException("Database connection is not initialized.");
        }
        String deleteQuery = "DELETE FROM defi WHERE id=" + id;
        try (Statement statement = connection.createStatement()) {
            int rowsAffected = statement.executeUpdate(deleteQuery);
            System.out.println(rowsAffected + " row(s) deleted.");
        }
    }
}
