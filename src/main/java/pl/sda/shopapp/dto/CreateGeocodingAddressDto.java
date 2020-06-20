package pl.sda.shopapp.dto;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.UUID;

public final class CreateGeocodingAddressDto {

    @javax.validation.constraints.NotNull
    private double latitude;

    @javax.validation.constraints.NotNull
    private double longitude;

    public CreateGeocodingAddressDto(@javax.validation.constraints.NotNull double latitude, @NotNull double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CreateGeocodingAddressDto that = (CreateGeocodingAddressDto) o;
        return Double.compare(that.latitude, latitude) == 0 &&
                Double.compare(that.longitude, longitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(latitude, longitude);
    }
}
