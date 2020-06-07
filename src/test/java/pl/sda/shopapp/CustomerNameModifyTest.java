package pl.sda.shopapp;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shopapp.entity.Address;
import pl.sda.shopapp.entity.Company;
import pl.sda.shopapp.entity.Person;
import pl.sda.shopapp.entity.VatNumber;
import pl.sda.shopapp.repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@Transactional
public class CustomerNameModifyTest {

    @Autowired
    private CustomerRepository repository;

    @Autowired
    private EntityManager em;

    @Test
    void testModifyName() {
        //given
        var company = new Company(new VatNumber("0123456789"), "CHANGE ME");
        repository.saveAndFlush(company);
        em.clear();


        //when
        int updated = repository.updateCompanyName(company.getId(), "TEST S.A.");
        repository.flush();

        //then
        assertEquals(1, updated);
        var customer = repository.findById(company.getId()).get();
        assertEquals("TEST S.A.", customer.getName());
    }
}
