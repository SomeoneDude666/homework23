package ru.netology;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTest extends FakeStrings {


    @Test
    void shouldSumbitRequest() {
        Faker faker = new Faker(new Locale("ru"));
        setCity(faker.address().cityName());
        setFirstName(faker.name().firstName());
        setLastName(faker.name().lastName());
        setPhone(faker.phoneNumber().phoneNumber());
        open("http://localhost:9999/");
        $("[placeholder]").setValue(getCity());
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        String dt = sdf.format(date);
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(sdf.parse(dt));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, 4);
        dt = sdf.format(c.getTime());
        $("[pattern='[0-9.]*']").doubleClick().sendKeys(Keys.DELETE);
        $("[pattern='[0-9.]*']").setValue(dt);
        $("[name='name']").setValue(getFirstName() + " " + getLastName());
        $("[name='phone']").setValue(getPhone());
        $(".checkbox__box").click();
        $("[role=button][type=button].button").click();
        $(withText("Успешно")).waitUntil(visible,15000);
        $("[role=button][type=button].button").click();
        $("#root > div > div:nth-child(4) > div.notification__content > button").click();
    }

    @Test
    void shouldAutoFillCity() {
        open("http://localhost:9999/");
        $("[placeholder]").setValue("аб");
        $(".menu-item__control").find("Хабаровск");
    }
}