package pl.sda.shopapp.dto;


import pl.sda.shopapp.entity.Address;

import javax.persistence.CascadeType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.UUID;

public class CustomerQueryResultDto {

    public enum CustomerType{
        COMPANY, PERSON;
    }

    private UUID customerId;
    private String name;
    private String taxId;
    private CustomerType type;

    public CustomerQueryResultDto(UUID customerId, String name, String taxId, CustomerType type) {
        this.customerId = customerId;
        this.name = name;
        this.taxId = taxId;
        this.type = type;
    }

    public UUID getCustomerId() {
        return customerId;
    }

    public String getName() {
        return name;
    }

    public String getTaxId() {
        return taxId;
    }

    public CustomerType getType() {
        return type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CustomerQueryResultDto that = (CustomerQueryResultDto) o;

        if (!customerId.equals(that.customerId)) return false;
        if (!name.equals(that.name)) return false;
        if (!taxId.equals(that.taxId)) return false;
        return type == that.type;
    }

    @Override
    public int hashCode() {
        int result = customerId.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + taxId.hashCode();
        result = 31 * result + type.hashCode();
        return result;
    }
}
