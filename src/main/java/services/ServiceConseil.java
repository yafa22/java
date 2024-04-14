package services;

import entites.Conseil;
import utils.MyDatabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ServiceConseil implements IService<Conseil> {
    Connection connection;
    public ServiceConseil(){
        connection= MyDatabase.getInstance().getConnection();
    }
    @Override
    public void ajouter(Conseil conseil) throws SQLException {
        String req="insert into conseil (titre ,contenu,categorie)"+
                "values('"+conseil.getTitre()+"','"+conseil.getContenu()+"','"+conseil.getCategorie()+"')";
        Statement statement = connection.createStatement();
        statement.executeUpdate(req);
        System.out.println("conseil ajouter ");
    }

    @Override
    public void modifier(Conseil conseil) throws SQLException {
        String req ="update conseil set titre=?,contenu=?,categorie=? where id=?";

        PreparedStatement preparedStatement = connection.prepareStatement(req);
        preparedStatement.setString(1,conseil.getTitre());
        preparedStatement.setString(2,conseil.getContenu());
        preparedStatement.setString(3,conseil.getCategorie());
        preparedStatement.setInt(4,conseil.getId());

        preparedStatement.executeUpdate();
        System.out.println("conseil updated");


    }

    @Override
    public void supprimer(int id) throws SQLException {
        String req ="delete from conseil where id="+id;
        Statement statement = connection.createStatement();
        statement.executeUpdate(req);

    }

    @Override
    public List<Conseil> afficher() throws SQLException {
        List<Conseil> conseils=new ArrayList<>();
        String req="select * from conseil ";
        Statement statement = connection.createStatement() ;
        ResultSet rs=statement.executeQuery(req);
        while (rs.next()) {
            Conseil conseil = new Conseil();
            conseil.setTitre(rs.getString("titre"));
            conseil.setContenu(rs.getString("contenu"));
            conseil.setCategorie(rs.getString("categorie"));
            conseil.setId(rs.getInt("id"));

            conseils.add(conseil);
        }
        return conseils;
    }
}
