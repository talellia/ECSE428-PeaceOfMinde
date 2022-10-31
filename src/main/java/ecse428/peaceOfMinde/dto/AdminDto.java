package ecse428.peaceOfMinde.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public class AdminDto {
    private int id;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String email;
    private String residentialAddress;
    private String about_description;


    /**
     * Constructor that creates the admin data transfer object
     *
     * @param firstName          First Name of Admin
     * @param lastName           Last Name of Admin
     * @param userName           Admin Username
     * @param password           Admin Password
     * @param email              Admin email
     * @param residentialAddress Admin Residential Address
     */
    public AdminDto(String firstName, String lastName, String userName, String password, String email,
                    String residentialAddress, String about) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.residentialAddress = residentialAddress;
        this.about_description = about;
    }
}
