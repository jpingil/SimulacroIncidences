/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * clase que representa unha incidencia que se produciu nun sistema
 *
 * @author jorge
 */
public class Incidence {

    private int id;
    private String description;
    private String computer;
    private String resolution;
    private int status;

    /**
     * constante para atributo status
     */
    public static final int STATUS_UNSOLVED = 0;

    /**
     * constante para atributo status
     */
    public static final int STATUS_PENDING = 1;

    /**
     * constante para atributo status
     */
    public static final int STATUS_SOLVED = 2;

    private User sender;

    /**
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * modificar o valor do id
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * modificar o valor da description
     * @param description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     *
     * @return computer
     */
    public String getComputer() {
        return computer;
    }

    /**
     * modificar o valor do computer
     * @param computer
     */
    public void setComputer(String computer) {
        this.computer = computer;
    }

    /**
     *
     * @return resolution
     */
    public String getResolution() {
        return resolution;
    }

    /**
     * modificar o valor da resolution
     * @param resolution
     */
    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    /**
     *
     * @return status
     */
    public int getStatus() {
        return status;
    }

    /**
     * modificar o valor do status
     * @param status
     */
    public void setStatus(int status) {
        this.status = status;
    }

    /**
     * 
     * @return sender
     */
    public User getSender() {
        return sender;
    }

    /**
     * modificar o valor do sender
     * @param sender
     */
    public void setSender(User sender) {
        this.sender = sender;
    }

    /**
     *
     * @param id 
     * @param description
     * @param computer
     * @param resolution
     * @param status
     * @param sender
     */
    public Incidence(int id, String description, String computer, String resolution, int status, User sender) {
        this.id = id;
        this.description = description;
        this.computer = computer;
        this.resolution = resolution;
        this.status = status;
        this.sender = sender;
    }

}
