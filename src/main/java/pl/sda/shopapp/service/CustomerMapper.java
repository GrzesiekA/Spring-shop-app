package pl.sda.shopapp.service;

import org.springframework.stereotype.Component;
import pl.sda.shopapp.dto.CustomerQueryResultDto;
import pl.sda.shopapp.entity.Company;
import pl.sda.shopapp.entity.Customer;

import java.util.ArrayList;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Component
public class CustomerMapper {

    public List<CustomerQueryResultDto> map(List<Customer> customers) {
        return customers.stream().
                map(this::map).
                collect(toList());
    }


    private CustomerQueryResultDto map(Customer customer) {
        return new CustomerQueryResultDto(
                customer.getId(),
                customer.getName(),
                customer.getTaxId(),
                customer instanceof Company
                        ? CustomerQueryResultDto.CustomerType.COMPANY
                        : CustomerQueryResultDto.CustomerType.PERSON
        );
    }


}
