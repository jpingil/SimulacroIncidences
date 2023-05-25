
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 * clase principal do proxecto
 *
 * @author jorge
 */
public class IncidenceManager {

    public void showInitMenu() {
        User user;
        char exit;
        Scanner scan = new Scanner(System.in);
        System.out.println("INCIDENCES PROGRAM");
        System.out.println("");
        //repetimos isto mentres o user sexa null
        do {
            System.out.println("Introduza o seu nome de usuario: ");
            String userName = scan.nextLine();
            System.out.println("Introduza a sua contrasinal: ");
            String password = scan.nextLine();
            user = UserDB.findByNameAndPassword(userName, password);
        } while (user == null);
        System.out.println("");
        showIncidencesMenu(user);

    }

    private void showIncidencesMenu(User user) {
        Scanner scan = new Scanner(System.in);
        if (user.getType() == user.USER) {
            System.out.println("Benvid@ " + user.getName());
            //mostramos as incidencias
            System.out.println("As túas incidencias: ");
            for (Incidence incidence : IncidenceDB.findByUser(user.getUserName())) {
                String status;
                if (incidence.getStatus() == Incidence.STATUS_UNSOLVED) {
                    status = "(sen resolver)";
                } else if (incidence.getStatus() == Incidence.STATUS_PENDING) {
                    status = "(pendente)";
                } else {
                    status = "(resolta)";
                }
                System.out.println(incidence.getStatus() + "" + status + ":" + incidence.getDescription());
            }
            System.out.println("");
            System.out.println("Escolle unha opción: ");
            System.out.println("1. Crear unha incidencia");
            System.out.println("2. Pechar sesión");
            int option = scan.nextInt();
            scan.nextLine();
            switch (option) {
                //creamos a incidencia
                case 1:
                    System.out.println("Introduce a descripción da incidencia:");
                    String description = scan.nextLine();
                    System.out.println("Indica o equipo sobre o que trata a incidencia:");
                    String computer = scan.nextLine();
                    Incidence incidence = new Incidence(0, description, computer, "", Incidence.STATUS_UNSOLVED, user);
                    IncidenceDB.save(incidence);
                    System.out.println("");
                    showIncidencesMenu(user);
                    break;
                case 2:
                    char exit;
                    System.out.println("Quere pechar a aplicación?(S/N)");
                    exit = scan.nextLine().charAt(0);
                    if (exit == 'N' || exit == 'n') {
                        showInitMenu();
                    }
                    break;
            }
        }else{
            IncidenceAdmin admin = new IncidenceAdmin();
            admin.setVisible(true);
        }
    }

    public static void main(String[] args) {
        IncidenceManager session = new IncidenceManager();
        session.showInitMenu();
    }
}
