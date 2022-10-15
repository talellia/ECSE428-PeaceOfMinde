package ecse428.peaceOfMinde.model;

import javax.persistence.*;

import java.util.*;
import java.sql.Date;

@Entity
public class Worker extends Person {

    //------------------------
    // MEMBER VARIABLES
    //------------------------

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Worker(Integer aId, String aFirst_name, String aLast_name, String aResidential_address) {
        super(aId, aFirst_name, aLast_name, aResidential_address);
    }

    public Worker() {

    }
    //------------------------
    // INTERFACE
    //------------------------

    public String toString() {
        return super.toString();
    }
}