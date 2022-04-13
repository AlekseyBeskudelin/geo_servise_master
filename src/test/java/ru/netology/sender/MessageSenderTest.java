package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.i18n.LocalizationService;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class MessageSenderTest {

    @Test
    void send() {
            GeoService geo = Mockito.mock(GeoService.class);
            Mockito.when(geo.byIp("172.0.32.11"))
                    .thenReturn (new Location("Moscow", Country.RUSSIA, "Lenina", 15));
            LocalizationService localization = Mockito.mock(LocalizationService.class);
            Mockito.when(localization.locale(Country.RUSSIA))
                    .thenReturn("Добро пожаловать");
            MessageSender messageSender = new MessageSenderImpl (geo, localization);
            Map<String, String> headers = new HashMap<String, String>();
            headers.put(MessageSenderImpl.IP_ADDRESS_HEADER,"172.0.32.11");
            messageSender.send(headers);
            Assertions.assertEquals("Добро пожаловать", messageSender.send(headers));
    }
}