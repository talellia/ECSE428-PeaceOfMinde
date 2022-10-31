package ecse428.peaceOfMinde.model;

import java.util.*;
import javax.persistence.*;

@Entity
public class Buyer extends Person {

    //------------------------
    // MEMBER VARIABLES
    //------------------------
    @ElementCollection
    private List<String> listComments;



    //------------------------
    // CONSTRUCTOR
    //------------------------

    public Buyer(Integer aId, String aFirst_name, String aLast_name, String aResidential_address,String aAboutMe, List<String> aListComments) {
        super(aId, aFirst_name, aLast_name, aResidential_address,aAboutMe);
        listComments = aListComments;
    }

    public Buyer() {

    }

    
    /** 
     * @return List<String>
     */
    //------------------------
    // INTERFACE
    //------------------------
    public List<String> getListComments() {
        return this.listComments;
    }

    
    /** 
     * @param listComments
     * @return boolean
     */
    public boolean setListComments(List<String> listComments) {
        this.listComments = listComments;
        return true;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return super.toString();
    }
}