package ru.netology.sender;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.netology.entity.Country;
import ru.netology.entity.Location;
import ru.netology.geo.GeoService;
import ru.netology.geo.GeoServiceImpl;
import ru.netology.i18n.LocalizationService;
import ru.netology.i18n.LocalizationServiceImpl;

import java.util.HashMap;
import java.util.Map;

class MessageSenderImplTest {

    @Test
    void sendTestRussia() {
        String msg = "Добро пожаловать";
        GeoService geo = Mockito.spy(GeoServiceImpl.class);
        LocalizationService loc = Mockito.spy(LocalizationServiceImpl.class);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "172.123.12.19");
        MessageSender messageSender = new MessageSenderImpl(geo, loc);
        String target = messageSender.send(headers);
        Assertions.assertEquals(msg, target);
    }
    @Test
    void sendTestUsa() {
        String msg = "Welcome";
        GeoService geo = Mockito.spy(GeoServiceImpl.class);
        LocalizationService loc = Mockito.spy(LocalizationServiceImpl.class);
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(MessageSenderImpl.IP_ADDRESS_HEADER, "96.44.183.149");
        MessageSender messageSender = new MessageSenderImpl(geo, loc);
        String target = messageSender.send(headers);
        Assertions.assertEquals(msg, target);
    }
}