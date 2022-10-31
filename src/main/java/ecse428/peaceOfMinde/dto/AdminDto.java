package ecse428.peaceOfMinde.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@EqualsAndHashCode
@ToString
@AllArgsConstructor
public final class AdminDto {
    @Setter
    private int id;
    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String password;
    private final String email;
    private final String residentialAddress;
    private final String about_description;


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
