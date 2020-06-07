package pl.sda.shopapp.service;


import org.springframework.stereotype.Service;
import pl.sda.shopapp.dto.CreateCompanyDto;
import pl.sda.shopapp.dto.CustomerQueryDto;
import pl.sda.shopapp.dto.CustomerQueryResultDto;
import pl.sda.shopapp.entity.Address;
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
    private final GoogleAddressService addressService;

    public CustomerService(CustomerRepository repository,
                           CustomerMapper mapper,
                           GoogleAddressService addressService) {
        requireNonNulls(repository);
        this.repository = repository;
        this.mapper = mapper;
        this.addressService = addressService;
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

       @Transactional
       public void createAddress(UUID customerId, double latitude, double longitude) {
           var address = addressService.findAddress(latitude, longitude);
           var customer = repository.getOne(customerId);
           customer.addAddress(new Address(
                   address.getStreet(), address.getCity(), address.getZipCode(), address.getCountry()));
           repository.save(customer);
       }
    }

