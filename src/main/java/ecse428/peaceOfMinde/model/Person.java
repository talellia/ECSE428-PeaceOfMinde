package ecse428.peaceOfMinde.model;

import javax.persistence.*;
import java.util.*;
import java.sql.Date;

@Entity
@Table
public abstract class Person {

    //------------------------
    // STATIC VARIABLES
    //------------------------

    private static Map<Integer, Person> personsById = new HashMap<Integer, Person>();

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //Person Attributes
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String firstName;
    @Column
    private String lastName;
    @Column
    private String username;
    @Column
    private String password;
    @Column
    private String email;
    @Column
    private String residentialAddress;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Person(Integer aId, String aFirst_name, String aLast_name, String aResidential_address) {
        firstName = aFirst_name;
        lastName = aLast_name;
        username = null;
        password = null;
        email = null;
        residentialAddress = aResidential_address;
        if (!setId(aId)) {
            throw new RuntimeException("Cannot create due to duplicate id.");
        }
    }

    public Person() {

    }

    //------------------------
    // INTERFACE
    //------------------------

    public boolean setId(Integer aId) {
    	// TODO: @sacha - go through update logic
    	this.id = aId;
    	
        boolean wasSet = false;
        Integer anOldId = getId();
        if (anOldId != null && anOldId.equals(aId)) {
            return true;
        }
        if (hasWithId(aId)) {
            return wasSet;
        }
        id = aId;
        wasSet = true;
        if (anOldId != null) {
            personsById.remove(anOldId);
        }
        personsById.put(aId, this);
        return wasSet;
    }

    public boolean setFirstName(String aFirst_name) {
        boolean wasSet = false;
        firstName = aFirst_name;
        wasSet = true;
        return wasSet;
    }

    public boolean setLastName(String aLast_name) {
        boolean wasSet = false;
        lastName = aLast_name;
        wasSet = true;
        return wasSet;
    }

    public boolean setUsername(String aUsername) {
        boolean wasSet = false;
        username = aUsername;
        wasSet = true;
        return wasSet;
    }

    public boolean setPassword(String aPassword) {
        boolean wasSet = false;
        password = aPassword;
        wasSet = true;
        return wasSet;
    }

    public boolean setEmail(String aEmail) {
        boolean wasSet = false;
        email = aEmail;
        wasSet = true;
        return wasSet;
    }

    public boolean setResidentialAddress(String aResidential_address) {
        boolean wasSet = false;
        residentialAddress = aResidential_address;
        wasSet = true;
        return wasSet;
    }

    public Integer getId() {
        return id;
    }

    public static Person getWithId(Integer aId) {
        return personsById.get(aId);
    }

    public static boolean hasWithId(Integer aId) {
        return getWithId(aId) != null;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getResidentialAddress() {
        return residentialAddress;
    }

    public void delete() {
        personsById.remove(getId());
    }

    public String toString() {
        return super.toString() + "[" +
                "id" + ":" + getId() + "," +
                "firstName" + ":" + getFirstName() + "," +
                "lastName" + ":" + getLastName() + "," +
                "username" + ":" + getUsername() + "," +
                "password" + ":" + getPassword() + "," +
                "email" + ":" + getEmail() + "," +
                "residentialAddress" + ":" + getResidentialAddress() + "]";
    }
}