package Models.domain;

public class UsersDTO {

    private int idUser;
    private String name;
    private String lastName;
    private String phone;
    private String postalCode;
    private String address;
    private String email;
    private String password;

    public UsersDTO(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public UsersDTO(String name, String lastName, String phone, String postalCode, String address, String email, String password) {
        this.idUser = idUser;
        this.name = name;
        this.lastName = lastName;
        this.phone = phone;
        this.postalCode = postalCode;
        this.address = address;
        this.email = email;
        this.password = password;
    }

    public int getIdUser() {
        return idUser;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
