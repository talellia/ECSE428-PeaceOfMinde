package ecse428.peaceOfMinde.model;

import java.sql.Date;
import java.util.*;
import javax.persistence.*;

@Entity
public class Buyer extends Person {

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Buyer(Integer aId, String aFirst_name, String aLast_name, String aResidential_address) {
        super(aId, aFirst_name, aLast_name, aResidential_address);
    }

    public Buyer() {

    }

    //------------------------
    // INTERFACE
    //------------------------

    public String toString() {
        return super.toString();
    }
}