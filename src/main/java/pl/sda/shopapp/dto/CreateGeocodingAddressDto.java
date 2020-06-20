package pl.sda.shopapp.dto;

import com.sun.istack.NotNull;

import java.util.UUID;

public final class CreateGeocodingAddressDto {

    @NotNull
    private UUID custometId;

    @NotNull
    private double latitude;

    @NotNull
    private double longitude;

    public CreateGeocodingAddressDto(@NotNull double latitude, @NotNull double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }
}
