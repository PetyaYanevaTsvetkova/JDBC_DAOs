import com.github.javafaker.Faker;
import com.github.javafaker.service.FakeValuesService;
import com.github.javafaker.service.RandomService;
import daoService.DAOimpl.AddressDAO;
import daoService.DAOimpl.CustomerDAO;
import entity.Address;
import entity.Customer;

import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class AppRunner {
    public static void main(String[] args) throws SQLException, IOException {
        AddressDAO addressDAO = new AddressDAO();
        CustomerDAO customerDAO = new CustomerDAO();

        //Save address:
        addressDAO.save(buildAddress());
        customerDAO.save(buildCustomer());

        //DeleteById
        addressDAO.deleteById(5L);
        customerDAO.deleteById(3L);

        //DeleteAll
//        addressDAO.deleteAll();
//        customerDAO.deleteAll();

        //GetById
        addressDAO.getById(5L);
        customerDAO.getById(7L);

        //getByIds
        addressDAO.getByIds(List.of(1L, 3L, 5L));
        customerDAO.getByIds(List.of(2L, 8L, 6L));

        //getAllRecordsCount
        addressDAO.getAllRecordsCount();
        customerDAO.getAllRecordsCount();

        //getRandomId
        addressDAO.getRandomId();
        customerDAO.getRandomId();

        //getRandomIds
        addressDAO.getRandomIds(10);
        customerDAO.getRandomIds(5);
    }

    private static Address buildAddress() {
        Faker faker = new Faker();

        Address address = Address.builder()
                .address_id(9L)
                .customer_id(6L)
                .address("34 Sveti Nikola Str.")
                .city(faker.address().city())
                .province(null)
                .state_uk(null)
                .postal_code(5498)
                .country(faker.address().country())
                .build();
        return address;
    }

    private static Customer buildCustomer() {
        Faker faker = new Faker();
        FakeValuesService fakeValuesService = new FakeValuesService(new Locale("en-GB"), new RandomService());

        Customer customer = Customer.builder()
                .customer_id(14L)
                .name("Pesho")
                .email(fakeValuesService.bothify("????##@gmail.com"))
                .phone("0889548621")
                .age(31)
                .address(faker.address().fullAddress())
                .city(faker.address().city())
                .postal_code(3547)
                .country(faker.address().country())
                .consent_status(faker.random().nextBoolean())
                .is_profile_active(faker.random().nextBoolean())
                .date_profile_created(Date.valueOf(LocalDate.now()))
                .date_profile_deactivated(Date.valueOf(LocalDate.now()))
                .reason_for_deactivation("error")
                .notes("")
                .build();
        return customer;
    }
}

