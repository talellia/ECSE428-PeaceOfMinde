package ecse428.peaceOfMinde.model;

import javax.persistence.*;

import java.util.*;
import java.sql.Date;

@Entity
public class Worker extends Person {

    //------------------------
    // MEMBER VARIABLES
    //------------------------
    @Column
    private boolean isRegisteredOnline;

    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Worker(Integer aId, String aFirst_name, String aLast_name, String aResidential_address, String aAboutMe, boolean aIsRegisteredOnline) {
        super(aId, aFirst_name, aLast_name, aResidential_address, aAboutMe);
        isRegisteredOnline = aIsRegisteredOnline;
    }

    public Worker() {

    }
    //------------------------
    // INTERFACE
    //------------------------
    public boolean getIsRegisteredOnline() {
        return isRegisteredOnline;
    }

    public boolean setIsRegisteredOnline(boolean aIsRegisteredOnline) {
        isRegisteredOnline = aIsRegisteredOnline;
        return true;
    }

    public String toString() {
        return super.toString() + "[" +
                "isRegisteredOnline" + ":" + getIsRegisteredOnline() + "]";
    }
}