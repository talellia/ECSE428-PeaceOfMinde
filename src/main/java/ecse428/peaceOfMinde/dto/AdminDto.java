package ecse428.peaceOfMinde.dto;

import lombok.Builder;

import java.util.Objects;

@Builder
public final class AdminDto {

    private final String firstName;
    private final String lastName;
    private final String userName;
    private final String password;
    private final String email;
    private final String residentialAddress;

    public AdminDto(String firstName, String lastName, String userName, String password, String email,
                    String residentialAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
        this.password = password;
        this.email = email;
        this.residentialAddress = residentialAddress;
    }

    public String firstName() {
        return firstName;
    }

    public String lastName() {
        return lastName;
    }

    public String userName() {
        return userName;
    }

    public String password() {
        return password;
    }

    public String email() {
        return email;
    }

    public String residentialAddress() {
        return residentialAddress;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        AdminDto that = (AdminDto) obj;
        return Objects.equals(this.firstName, that.firstName) &&
                Objects.equals(this.lastName, that.lastName) &&
                Objects.equals(this.userName, that.userName) &&
                Objects.equals(this.password, that.password) &&
                Objects.equals(this.email, that.email) &&
                Objects.equals(this.residentialAddress, that.residentialAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userName, password, email, residentialAddress);
    }

    @Override
    public String toString() {
        return "AdminDto[" +
                "firstName=" + firstName + ", " +
                "lastName=" + lastName + ", " +
                "userName=" + userName + ", " +
                "password=" + password + ", " +
                "email=" + email + ", " +
                "residentialAddress=" + residentialAddress + ']';
    }

}
