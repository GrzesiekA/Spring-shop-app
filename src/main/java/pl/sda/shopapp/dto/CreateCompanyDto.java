package pl.sda.shopapp.dto;

import com.sun.istack.NotNull;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.util.Objects;

public final class CreateCompanyDto {

    @NotNull
    @NotBlank
    private String name;

    @NotNull
    @Pattern(regexp = "\\d{10}")
    private String vatNumber;

    public CreateCompanyDto(String name, String vatNumber) {
        this.name = name;
        this.vatNumber = vatNumber;
    }

    public String getName() {
        return name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CreateCompanyDto that = (CreateCompanyDto) o;

        if (!name.equals(that.name)) return false;
        return vatNumber.equals(that.vatNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, vatNumber);
    }
}
