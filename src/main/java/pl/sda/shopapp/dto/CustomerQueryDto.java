package pl.sda.shopapp.dto;

public final class CustomerQueryDto {
    private String name;
    private String taxId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTaxId() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId = taxId;
    }


}
