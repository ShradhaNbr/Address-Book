public class Contact {
    public int number;
    public String firstName;
    public String lastName;
    public String address;
    public String city;
    public String state;
    public int zipCode;
    public String phoneNumber;
    public String email;

    public Contact(int number, String firstName, String lastName, String address, String city, String state, int zipCode, String phoneNumber, String emailId) {
        this.number = number;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.phoneNumber = phoneNumber;
        this.email = emailId;
    }
}