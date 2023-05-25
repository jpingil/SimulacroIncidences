/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * clase que implementa un usario da apliación
 *
 * @author jorge
 */
public class User {

    private String userName;
    private String password;
    private String name;
    private String surname;
    private int type;

    /**
     * constante do atributo type
     */
    public static final int USER = 0;

    /**
     * constante do atributo type
     */
    public static final int ADMIN = 1;

    /**
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * modificar o valor de userName
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * modificar o valor de password
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * modificar o valor de name
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     *
     * @return surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * modificar o valor de surname
     * @param surname
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     *
     * @return type
     */
    public int getType() {
        return type;
    }

    /**
     * modificar o valor de type
     * @param type
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     *
     * @param userName
     * @param password
     * @param name
     * @param type
     */
    public User(String userName, String password, String name, String surname,int type) {
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.surname = surname;
        this.type = type;
    }
    
    
}
