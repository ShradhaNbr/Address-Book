import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AddressBookDB {
    private static AddressBookDB addressBookDB;
    private PreparedStatement personInfoDataStatement;

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

    public int updateContact(String name, String address) {
        return this.updatePersonInfoUsingStatement(name,address);
    }

    private int updatePersonInfoUsingStatement(String name, String address) {
        String sql = String.format("UPDATE address_book SET address = '%s' WHERE firstname = '%s';", address, name);
        try (Connection connection = this.getConnection()){
            Statement statement = connection.createStatement();
            return statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public List<Contact> getPersonInfoData(String name) {
        List<Contact> contacts = null;
        if(this.personInfoDataStatement == null)
            this.preparedStatementForPersonInfo();
        try {
            personInfoDataStatement.setString(1, name);
            ResultSet resultSet = personInfoDataStatement.executeQuery();
            contacts = this.getPersonInfoData(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contacts;
    }

    private void preparedStatementForPersonInfo() {
        try {
            Connection connection = this.getConnection();
            String sql = "SELECT * FROM address_book WHERE firstname = ?";
            personInfoDataStatement = connection.prepareStatement(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<Contact> getPersonInfoData(ResultSet resultSet) {
        List<Contact> addressBookList = new ArrayList<>();
        try {
            while (resultSet.next()) {
                int number = resultSet.getInt("number");
                String type = resultSet.getString("type");
                String firstName = resultSet.getString("first_name");
                String lastName = resultSet.getString("last_name");
                String address = resultSet.getString("address");
                String city = resultSet.getString("city");
                String state = resultSet.getString("state");
                int zip = resultSet.getInt("zip");
                String phoneNumber = resultSet.getString("phone_number");
                String emailId = resultSet.getString("Email");
                addressBookList.add(new Contact(number, firstName, lastName, address, city, state, zip, phoneNumber, emailId));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return addressBookList;
    }

}

