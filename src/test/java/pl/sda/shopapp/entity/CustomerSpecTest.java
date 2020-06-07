package pl.sda.shopapp.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shopapp.dto.CustomerQueryDto;
import pl.sda.shopapp.repository.CustomerRepository;
import pl.sda.shopapp.repository.CustomerSpec;

import javax.transaction.Transactional;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class CustomerSpecTest {

    @Autowired
    private CustomerRepository repository;

    @Test
    void testSpec() {
        //given
        var query = new CustomerQueryDto();
        query.setName("Jan");
        query.setTaxId("89302002003");

        var person1 = new Person("Jan", "Kowalski", "89302002003");
        var person2 = new Person("Janina", "Nowak", "89302002103");
        repository.saveAll(Arrays.asList(person1, person2));

        //when
        var customers = repository.findAll(CustomerSpec.withQuery(query));

        //then
        assertEquals(1, customers.size());
    }
}

