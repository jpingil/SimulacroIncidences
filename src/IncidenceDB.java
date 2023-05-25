
import java.util.ArrayList;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * clase que implementa a persistencia das incidencias
 *
 * @author jorge
 */
public class IncidenceDB {

    private static ArrayList<Incidence> incidences = new ArrayList<>();

    /**
     * metodo para encontrar as incidencias de un user polo seu userName
     *
     * @param userName
     * @return ArrayList das incidencias de userName
     */
    public static ArrayList<Incidence> findByUser(String userName) {
        ArrayList<Incidence> result = new ArrayList<>();
        Connection c = UserDB.getConnection();
        try {
            // Buscamos na BD as incidencias do usuario
            PreparedStatement pst = c.prepareStatement("SELECT * FROM Incidence "
                    + "WHERE sender=?");
            pst.setString(1, userName);
            ResultSet rst = pst.executeQuery();
            // Engadimos cada fila do resultado no resultado como un obxecto
            // da clase Incidence
            while (rst.next()) {
                Incidence incidence = new Incidence(rst.getInt("id"),
                        rst.getString("description"), rst.getString("resolution"),
                        rst.getString("computer"), rst.getInt("status"),
                        new User(userName, "", "", "", 0));
                result.add(incidence);
            }
            // Pechamos o resultset e o statement
            rst.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar as incidencias: " + e.getMessage());
        }
        return result;
    }

    /**
     * metodo para encontrar as incidencias a partir dun status
     *
     * @param status
     * @return ArrayList das incidencias co correspondente status
     */
    public static ArrayList<Incidence> findByStatus(int status) {
        ArrayList<Incidence> statusIncidence = new ArrayList<>();
//        for (Incidence incidence : incidences) {
//            if (incidence.getStatus() == status) {
//                statusIncidence.add(incidence);
//            }
//        }
        Connection c = UserDB.getConnection();
        try {
            PreparedStatement pst = c.prepareStatement(
                    "SELECT * FROM Incidence i join User u on i.sender= u.username where status = ?");
            pst.setInt(0, status);
            ResultSet rst = pst.executeQuery();
            while (rst.next()) {
                Incidence incidence = new Incidence(rst.getInt("id"),
                        rst.getString("description"), rst.getString("computer"),
                        rst.getString("resolution"), rst.getInt("status"),
                        new User(rst.getString("username"),
                                rst.getString("password"), rst.getString("name"),
                                rst.getString("surname"), rst.getInt("type")));
                statusIncidence.add(incidence);
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Non se atopou o estado " + e.getMessage());
        }
        return statusIncidence;
    }

    /**
     * metodo para modificar o id da incidencia e gardala
     *
     * @param incidence
     */
    public static void save(Incidence incidence) {
        Connection c = UserDB.getConnection();
        try {
            // Formamos e executamos a consulta de inserción
            PreparedStatement pst = c.prepareStatement("INSERT INTO Incidence "
                    + "(description,computer,resolution,status, sender) "
                    + "VALUES(?,?,?,?,?)");
            pst.setString(1, incidence.getDescription());
            pst.setString(2, incidence.getComputer());
            pst.setString(3, incidence.getResolution());
            pst.setInt(4, incidence.getStatus());
            pst.setString(5, incidence.getSender().getUserName());
            pst.execute();
            // Pechamos o statement
            pst.close();
        } catch (SQLException e) {
            System.out.println("Erro ao gardar a incidencia: " + e.getMessage());
        }
    }

    public static void update(Incidence incidence) {
        Connection c = UserDB.getConnection();
        try {
            // Formamos e executamos a consulta de actualización
            PreparedStatement pst = c.prepareStatement(
                    "UPDATE Incidence SET status=?, resolution=? WHERE id=?");
            pst.setInt(1, incidence.getStatus());
            pst.setString(2, incidence.getResolution());
            pst.setInt(3, incidence.getId());
            pst.execute();
            // Pechamos o statement
            pst.close();
        } catch (SQLException e) {
            System.out.println("Erro ao gardar a incidencia: " + e.getMessage());
        }
    }

}
