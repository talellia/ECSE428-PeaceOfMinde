package ecse428.peaceOfMinde.dto;

import java.sql.Date;

/**
 * This class refers to the Buyer Data Transfer Object
 * This is required to access and manipulate data of the buyer
 *
 * @author Gohar Saqib Fazal
 */
public class BuyerDto {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String residentialAddress;

    /**
     * Constructor that creates the buyer data transfer object
     *
     * @param firstName          First Name of Buyer
     * @param lastName           Last Name of Buyer
     * @param userName           Buyer Username
     * @param password           Buyer Password
     * @param email              Buyer email
     * @param residentialAddress Buyer Residential Address
     */
    public BuyerDto(String firstName, String lastName, String userName, String password, String email,
                   String residentialAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.residentialAddress = residentialAddress;
    }

    public BuyerDto() {

    }

    /**
     * returns the buyer identification number
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * sets the buyer identification number
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the first name of the buyer
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name of the buyer
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * returns the last name of the buyer
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name of the buyer
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * returns the username of the buyer
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * sets the username of the buyer
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * returns the password of the buyer
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password of the buyer
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * returns the email of the buyer
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the email of the buyer
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * returns the buyer residential address
     *
     * @return residentialAddress
     */
    public String getResidentialAddress() {
        return residentialAddress;
    }

    /**
     * sets the buyer residential address
     *
     * @param residentialAddress
     */
    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

}