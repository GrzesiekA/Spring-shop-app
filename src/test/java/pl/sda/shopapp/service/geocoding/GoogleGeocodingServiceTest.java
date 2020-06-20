package pl.sda.shopapp.service.geocoding;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import pl.sda.shopapp.dto.GeocodeAddressDto;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class GoogleGeocodingServiceTest {

    @Autowired
    private GoogleGeocodingService addressService;

    @Test
    void testFindAddress(){
        //given
        var latitude = 52.250714;
        var longitude = 20.876190;

        //when
        var address = addressService.find(latitude, longitude);

        //then
        assertEquals(new GeocodeAddressDto("Spychowska 2A", "01-472", "Warszawa", "PL"),address);

    }

}
