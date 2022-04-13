package ru.netology.geo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.entity.Country;
import ru.netology.entity.Location;

import static org.junit.jupiter.api.Assertions.*;

class GeoServiceImplTest {

    @Test
    public void byIpTest() {
       final Location target = new Location("Moscow", Country.RUSSIA, "Lenina", 15);
       final String someIp = "172.0.32.11";
       GeoService geo = new GeoServiceImpl();

       final Location result = geo.byIp(someIp);

        Assertions.assertEquals(target.getStreet(), result.getStreet());




    }


}