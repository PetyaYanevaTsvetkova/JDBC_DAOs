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

        //SaveInDB:
        addressDAO.save(buildAddress());
        customerDAO.save(buildCustomer());

        //DeleteById
//        addressDAO.deleteById(1L);
//        customerDAO.deleteById(3L);

        //GetById
//        addressDAO.getById(5L);
//        customerDAO.getById(9L);

        //getByIds
//        addressDAO.getByIds(List.of(1L, 4L, 5L));
//        customerDAO.getByIds(List.of(2L, 6L, 8L));

        //getAllRecordsCount
//        addressDAO.getAllRecordsCount();
//        customerDAO.getAllRecordsCount();

        //getRandomId
//        addressDAO.getRandomId();
//        customerDAO.getRandomId();

        //getRandomIds
//        addressDAO.getRandomIds(5);
//        customerDAO.getRandomIds(6);

        //DeleteAll
//        addressDAO.deleteAll();
//        customerDAO.deleteAll();
    }

    private static Address buildAddress() {
        Faker faker = new Faker();

        Address address = Address.builder()
                .address_id(faker.number().numberBetween(7L, 20L))
                .customer_id(faker.number().numberBetween(1L, 12L))
                .address(faker.address().fullAddress())
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
                .customer_id(faker.number().numberBetween(13L, 20L))
                .name(faker.name().firstName())
                .email(fakeValuesService.bothify("????##@gmail.com"))
                .phone(faker.numerify("############"))
                .age(faker.random().nextInt(18, 100))
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

