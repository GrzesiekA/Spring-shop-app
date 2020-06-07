package pl.sda.shopapp.service;


import org.springframework.stereotype.Service;
import pl.sda.shopapp.dto.CreateCompanyDto;
import pl.sda.shopapp.dto.CustomerQueryDto;
import pl.sda.shopapp.dto.CustomerQueryResultDto;
import pl.sda.shopapp.entity.Company;
import pl.sda.shopapp.entity.VatNumber;
import pl.sda.shopapp.repository.CustomerRepository;
import pl.sda.shopapp.repository.CustomerSpec;

import javax.transaction.Transactional;

import java.util.List;
import java.util.UUID;

import static pl.sda.shopapp.util.Preconditions.*;

@Service
public class CustomerService {

    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public CustomerService(CustomerRepository repository, CustomerMapper mapper) {
        requireNonNulls(repository);
        this.repository = repository;
        this.mapper = mapper;
    }

    @Transactional
    public UUID createCompany(CreateCompanyDto dto) {
        var company = new Company(new VatNumber(dto.getVatNumber()), dto.getName());
        repository.save(company); /*trafia do do casha, po wykonaniu metody zostanie to zainsertowanie do bazy danych;*/
        return company.getId();
    }

    public List<CustomerQueryResultDto> findCustomer(CustomerQueryDto query){
          var customers = repository.findAll(CustomerSpec.withQuery(query));
          return mapper.map(customers);

       }
    }


