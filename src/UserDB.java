
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * clase que implementa a persistencia dos usuario na aplicacion
 *
 * @author jorge
 */
public class UserDB {

    private static Connection connection = null;

    private static User[] users = new User[]{
        new User("jorge", "123", "Jorge", "Pino", User.ADMIN),
        new User("miguel", "123", "Miguel", "Bastos", User.USER),
        new User("jacobo", "123", "Jacobo", "Pérez", 0)
    };

    /**
     * metodo para buscar un user polo ser userName
     *
     * @param userName
     * @return o user correspondente ou null
     */
    public static User findByName(String userName) {
        User user = null;
        Connection c = UserDB.getConnection();
        try {
            PreparedStatement pst = c.prepareStatement("select * from User where user name = ?");
            pst.setString(1, userName);
            ResultSet rst = pst.executeQuery();
            if (rst.next()) {
                user = new User(userName, rst.getString("password"),
                        rst.getString("name"), rst.getString("surname"), rst.
                                getInt("type"));
            }
            rst.close();
            pst.close();
        } catch (SQLException e) {
            System.out.println("Erro ao buscar o usuario: " + e.getMessage());
        }
        return user;
    }

    public static User findByNameAndPassword(String userName, String password) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public static Connection getConnection() {
        String db = "incidences";
        String url = "jdbc:sqlite:C:/Users/jorge/OneDrive/Documentos/1DAW/SimulacroProgramación/incidences.db";
        String user = "";
        String password = "";
        String driver = "org.sqlite.JDBC";

        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url + db, user, password);
            System.out.println("Se conecto a " + db);

        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("No se conecto a " + db);
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);

        }
        return connection;
    }
}
