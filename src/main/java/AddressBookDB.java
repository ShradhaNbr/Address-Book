import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {
    private static AddressBookDB addressBookDB;

    /**
     * Purpose : For creating a singleton object
     */
    public static AddressBookDB getInstance() {
        if (addressBookDB == null)
            addressBookDB = new AddressBookDB();
        return addressBookDB;
    }

    /**
     * Purpose : To read data from database using JDBC.
     */
    public List<Contact> getAddressBookData(String sql) {
        List<Contact> addressBookList = new ArrayList<>();
        try (Connection connection = this.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()) {
                int id = result.getInt("number");
                String firstName = result.getString("First_Name ");
                String lastName = result.getString("Last_Name ");
                String address = result.getString("Address ");
                String city = result.getString("City");
                String state = result.getString("State");
                int zipCode = result.getInt("zip");
                String phoneNumber = result.getString("Phone_Number");
                String email = result.getString("Email");
                addressBookList.add(new Contact(id, firstName, lastName, address, city, state, zipCode, phoneNumber, email));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

    /*
    Purpose: Read the persons data from DB
     */
    public List<Contact> readData() {
        String sql = "SELECT * FROM address_book";
        return getAddressBookData(sql);
    }
    /**
     * Purpose : Create connection with the database
     */
    private Connection getConnection() throws SQLException {

        String jdbcURL = "jdbc:mysql://localhost:3306/address_book_service;?characterEncoding=latin1";
        String userName = "root";
        String password = "bridgelabz";
        Connection connection;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver loaded");
        }catch (ClassNotFoundException e) {
            throw new IllegalStateException("Cannot find the driver in the class path", e);
        }
        System.out.println("Connecting to database :" +jdbcURL);
        connection = DriverManager.getConnection(jdbcURL, userName, password);
        System.out.println("Connection is successful!!!" + connection);
        return connection;
    }
}