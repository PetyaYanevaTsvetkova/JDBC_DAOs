package daoService.DAOimpl;
import daoService.DAO;
import dbconnection.DatabaseConnection;
import entity.Address;
import util.ResultSetMapper;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The class provides methods for CRUD operations with the Database.
 */
public class AddressDAO implements DAO<Address> {
    private final Connection connection;
    private ResultSet resultSet;
    private PreparedStatement preparedStatement;

    public AddressDAO() throws SQLException, IOException {
        this.connection = DatabaseConnection.getInstance().getConnection();
    }

    /**
     * Saves the record to the database.
     * @param address - Object of type Address.
     */
    @Override
    public void save(Address address) {
        try {
            this.preparedStatement = this.connection.prepareStatement("INSERT INTO customer_address \n" +
                    "(address_id, customer_id, address, city, province, state_UK, postal_code, country) \n" +
                    "VALUES \n" +
                    "(?, ?, ?, ?, ?, ?, ?, ?)");
            this.preparedStatement.setLong(1, address.getAddress_id());
            this.preparedStatement.setLong(2, address.getCustomer_id());
            this.preparedStatement.setString(3, address.getAddress());
            this.preparedStatement.setString(4, address.getCity());
            this.preparedStatement.setString(5, address.getProvince());
            this.preparedStatement.setString(6, address.getState_uk());
            this.preparedStatement.setInt(7, address.getPostal_code());
            this.preparedStatement.setString(8, address.getCountry());

            this.preparedStatement.executeUpdate();
            System.out.println("Address saved successfully.");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    /**
     * Deletes the record from the database.
     * @param address_id - id of the address record
     */
    @Override
    public void deleteById(Long address_id) {
        try {
            this.preparedStatement = this.connection.prepareStatement("DELETE FROM customer_address WHERE address_id = ?");
            this.preparedStatement.setLong(1, address_id);
            int i = this.preparedStatement.executeUpdate();
            System.out.printf("The records with id %d is deleted.%n", address_id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deletes all records in the table.
     */
    @Override
    public void deleteAll() {
        try {
            this.preparedStatement = this.connection.prepareStatement("DELETE FROM customer_address");
            int i = this.preparedStatement.executeUpdate();
            System.out.printf("All %d records are deleted.%n", i);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Takes a single record from the table by id.
     * @param id - id of the address record
     * @return - record from the Database with the id, given in the method parameter
     */
    @Override
    public Address getById(Long id) {
        Address searchedAddress = null;
        try {
            this.preparedStatement = this.connection.prepareStatement
                    ("SELECT * FROM customer_address WHERE address_id = ?");
            this.preparedStatement.setLong(1, id);
            this.resultSet = preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                searchedAddress = Address.builder()
                        .address_id(resultSet.getLong("address_id"))
                        .customer_id(resultSet.getLong("customer_id"))
                        .address(resultSet.getString("address"))
                        .city(resultSet.getString("city"))
                        .province(resultSet.getString("province"))
                        .state_uk(resultSet.getString("state_uk"))
                        .postal_code(resultSet.getInt("postal_code"))
                        .country(resultSet.getString("country"))
                        .build();
            }
            System.out.println(searchedAddress);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return searchedAddress;
    }

    /**
     * Takes a list of records by list of ids.
     * @param ids - List of ids of the address records.
     * @return - ArrayList containing list of records with the ids, given in the method parameter.
     */
    @Override
    public List<Address> getByIds(List<Long> ids) {
        ResultSetMapper resultSetMapper = new ResultSetMapper();
        try {
            this.preparedStatement = this.connection.prepareStatement
                    (String.format("SELECT * FROM customer_address WHERE address_id IN (%s)",
                            ids
                                    .stream()
                                    .map(id -> "?")
                                    .collect(Collectors.joining(", "))));

            for (int id = 0; id < ids.size(); id++) {
                this.preparedStatement.setLong(id + 1, ids.get(id));
            }
            this.resultSet = preparedStatement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        List<Address> searchedAddresses = resultSetMapper.mapResultSetToObject(this.resultSet, Address.class);
        searchedAddresses
                .stream()
                .forEach(System.out::println);
        return searchedAddresses;
    }

    /**
     * Takes the count of all records in the table.
     * @return - the count of all records in the table.
     */
    @Override
    public int getAllRecordsCount() {
        int recordsCount = 0;
        try {
            this.preparedStatement = this.connection.prepareStatement("SELECT COUNT(address_id) FROM customer_address");
            ResultSet resultSet = this.preparedStatement.executeQuery();
            if (resultSet.next()) {
                recordsCount = resultSet.getInt(1);
                System.out.printf("All records count is: %d%n", recordsCount);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return recordsCount;
    }

    /**
     * Takes a random record.
     * @return - returns random record from the Database.
     */
    @Override
    public Address getRandomId() {
        Address randomAddress = null;
        try {
            this.preparedStatement = this.connection.prepareStatement
                    ("SELECT * FROM customer_address ORDER BY RANDOM() LIMIT 1");
            this.resultSet = preparedStatement.executeQuery();

            while (this.resultSet.next()) {
                randomAddress = Address.builder()
                        .address_id(resultSet.getLong("address_id"))
                        .customer_id(resultSet.getLong("customer_id"))
                        .address(resultSet.getString("address"))
                        .city(resultSet.getString("city"))
                        .province(resultSet.getString("province"))
                        .state_uk(resultSet.getString("state_uk"))
                        .postal_code(resultSet.getInt("postal_code"))
                        .country(resultSet.getString("country"))
                        .build();
                System.out.println(randomAddress);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return randomAddress;
    }

    /**
     * Takes a random list of records.
     * @param randomCount - the count of random records.
     * @return - returns list of random records from the Database.
     */
    @Override
    public List<Address> getRandomIds(int randomCount) {
        ResultSetMapper resultSetMapper = new ResultSetMapper();
        List<Address> randomAddresses = null;
        try {
            this.preparedStatement = this.connection.prepareStatement
                    ("SELECT * FROM (SELECT DISTINCT * FROM customer_address) as AL ORDER BY RANDOM() LIMIT ?");
            this.preparedStatement.setInt(1, randomCount);
            this.resultSet = preparedStatement.executeQuery();
            randomAddresses = resultSetMapper.mapResultSetToObject(this.resultSet, Address.class);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        randomAddresses
                .stream()
                .forEach(System.out::println);
        return randomAddresses;
    }
}

