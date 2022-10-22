package ecse428.peaceOfMinde.model;

import javax.persistence.Entity;

@Entity
public class Admin extends Person{

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Admin(Integer aId, String aFirst_name, String aLast_name, String aResidential_address) {
        super(aId, aFirst_name, aLast_name, aResidential_address);
    }

    public Admin() {

    }

    //------------------------
    // INTERFACE
    //------------------------

    public String toString() {
        return super.toString();
    }
}
