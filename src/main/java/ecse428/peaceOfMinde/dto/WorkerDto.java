package ecse428.peaceOfMinde.dto;

/**
 * This class refers to the Worker Data Transfer Object
 * This is required to access and manipulate data of the worker
 *
 * @author Gohar Saqib Fazal
 */
public class WorkerDto {

    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String residentialAddress;
    private String about_description;

    /**
     * Constructor that creates the worker data transfer object
     *
     * @param firstName          First Name of Worker
     * @param lastName           Last Name of Worker
     * @param userName           Worker Username
     * @param password           Worker Password
     * @param email              Worker Email
     * @param residentialAddress Worker Residential Address
     * @param about              Worker About me description
     */
    public WorkerDto(String firstName, String lastName, String userName, String password,
                        String email, String residentialAddress, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.residentialAddress = residentialAddress;
        this.about_description = about;
    }

    public WorkerDto() {

    }

    /**
     * returns worker identification number
     *
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * sets worker identification number
     *
     * @param id
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * returns the first name of the worker
     *
     * @return firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * sets the first name of the worker
     *
     * @param firstName
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * returns the last name of the worker
     *
     * @return lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * sets the last name of the worker
     *
     * @param lastName
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * returns the username of the worker
     *
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * sets the username of the worker
     *
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * returns the password of the worker
     *
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * sets the password of the worker
     *
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * returns the email of the worker
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * sets the email of the worker
     *
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * returns the residential address of the worker
     *
     * @return residentialAddress
     */
    public String getResidentialAddress() {
        return residentialAddress;
    }

    /**
     * sets the residential address of the worker
     *
     * @param residentialAddress
     */
    public void setResidentialAddress(String residentialAddress) {
        this.residentialAddress = residentialAddress;
    }

    /**
     * returns the residential address of the worker
     *
     * @return residentialAddress
     */
    public String getAbout() {
        return about_description;
    }

    /**
     * sets the residential address of the worker
     *
     * @param residentialAddress
     */
    public void setAbout(String about) {
        this.about_description = about;
    }

}